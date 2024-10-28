const axios = require('axios');
const fs = require('fs');
const { type } = require('os');
const path = require('path');
const puppeteer = require('puppeteer');
const sharp = require('sharp');
require('dotenv').config();

(async () => {
    const notionApiKey = process.env.NOTION_API_KEY;
    const databaseId = process.env.DATABASE_ID;
    const targetUrl = process.env.TARGET_URL;
    const changedFiles = process.env.CHANGED_FILES.split('README.md'); // 변경된 파일 목록

    var difficultyDict = {};
    difficultyDict['Bronze'] = '브론즈';
    difficultyDict['Silver'] = '실버';
    difficultyDict['Gold'] = '골드';
    difficultyDict['Platinum'] = '플레티넘';

    // 커밋 메시지에서 정보를 추출 (example)
    const commitMessage = process.env.GITHUB_COMMIT_MESSAGE;
    const difficultyMatch = commitMessage.match(/\[(.+?)\]/);
    var difficulty = difficultyMatch ? difficultyMatch[1] : "알 수 없음";
    
    //영문 난이도를 한글 난이도로 변환
    for(key in difficultyDict){
        difficulty = difficulty.replace(key, difficultyDict[key]);
    }
    //Readme.md와 java 파일 가져오기
    let readmePath = path.join('https://raw.githubusercontent.com/taew0o/BOJ/main', changedFiles[0] + 'README.md');
    let javaPath = path.join('https://raw.githubusercontent.com/taew0o/BOJ/main', changedFiles[1].trim());
    
    // README.md 내용 가져오기
    const readmeContent = await fetchRawFileContent(readmePath);
    
    // Java 파일 내용 가져오기
    const javaCode = await fetchRawFileContent(javaPath);
    
    //문제 이름, 문제 번호, 알고리즘 분류 , 이미지 가져오기
    let title = '';
    let problemNum = '', problemName = '';
    let submissionDate = ''
    let algorithmCategories = [];
    let imageUrl = ''
    let problemLink = ''
    if(readmeContent){
        // 첫 번째 줄에서 문제 번호와 문제 이름 추출
        const firstLineMatch = readmeContent.match(/^# \[(.+?)\] (.+?) - (\d+)\s*$/m);
        if (firstLineMatch) {
            problemName = firstLineMatch[2];   // 문제 이름
            problemNum = firstLineMatch[3]; // 문제 번호
            title = problemNum + "-" + problemName
        }
        
        //제출 일자 추출
        const dateMatch = readmeContent.match(/### 제출 일자\s*\n(.+?)\s*$/m);
        if(dateMatch){
            const rawDate = dateMatch[1].trim(); // 제출 일자
            const formattedDate = rawDate.replace(/(\d+)년 (\d+)월 (\d+)일/, '$1-$2-$3');
            submissionDate = new Date(formattedDate).toISOString().split('T')[0]; // YYYY-MM-DD 형식으로 변환
        }
        //알고리즘 분류 리스트 추출
        const classificationMatch = readmeContent.match(/### 분류\s*\n([\s\S]*?)###/);
        if(classificationMatch){
            const classifications = classificationMatch[1].trim().split(',').map(cat => cat.trim());
            algorithmCategories = classifications.map(cat => ({name: cat}));
        }
        //문제 링크 url 추출 , 이미지 저장 및 링크 생성
        const linkMatch = readmeContent.match(/\[문제 링크\]\((.+?)\)/);
        if(linkMatch){
            problemLink = linkMatch[1];
            imageUrl = await createImageUrl(problemLink, title);
            console.log(imageUrl);
        }
    }
    //코드 가져오고 github page에 저장하기
    let codeArr = [];
    if(javaCode){
        let i = 0;
        while(i < javaCode.length){
            if(i + 2000 < javaCode.length){
                codeArr.push({
                    type: "text",
                    text: {
                        content: javaCode.substring(i, i + 2000)
                    }
                })
                i += 2000;
            }
            else{
                codeArr.push({
                    type: "text",
                    text: {
                        content: javaCode.substring(i)
                    }
                })
                break;
            }
        }
    }

    // Notion API에 요청할 데이터 작성
    const notionData = {
        parent: {
            database_id: databaseId
        },
        properties: {
            이름: {
                title: [
                    {
                        text: {
                            content: `${problemNum} - ${problemName}`
                        }
                    }
                ]
            },
            난이도: {
                select: {
                    name: difficulty
                }
            },
            "알고리즘 분류": {
                multi_select: algorithmCategories
            },
            날짜: {
                date: {
                    start: submissionDate
                }
            }
        },
        children: [
            {
                object: "block",
                type: "heading_2",
                heading_2: {
                    rich_text: [
                        {
                            type: "text",
                            text: {
                                content: "문제 캡쳐"
                            }
                        }
                    ]
                }
            },
            {
                object: "block",
                type: "embed",
                embed: {
                    url : imageUrl
                }
            },
            {
                object: "block",
                type: "heading_2",
                heading_2: {
                    rich_text: [
                        {
                            type: "text",
                            text: {
                                content: "\ncode"
                            }
                        }
                    ]
                }
            },
            {
                object: "block",
                type : "code",
                code : {
                    language : "java",
                    rich_text : codeArr
                }
            },
            {
                object: "block",
                type: "heading_2",
                heading_2: {
                    rich_text: [
                        {
                            type: "text",
                            text: {
                                content: "\ncomment"
                            }
                        }
                    ]
                }
            },
            {
                object: "block",
                type: "callout",
                callout: {
                    rich_text: [
                        {
                            type: "text",
                            text: {
                                content: " "
                            }
                        }
                    ]
                }
            }
        ]
    };

    // Notion API 요청
    try {
        const response = await axios.post('https://api.notion.com/v1/pages', notionData, {
            headers: {
                'Authorization': `Bearer ${notionApiKey}`,
                'Content-Type': 'application/json',
                'Notion-Version': '2022-06-28'
            }
        });
        console.log('Notion 페이지 생성 완료:', response.data);
    } catch (error) {
        console.error('Notion API 요청 실패:', error.response ? error.response.data : error.message);
    }
})();

// GitHub Raw URL에서 파일 내용을 가져오는 함수
async function fetchRawFileContent(url) {
    try {
        const response = await axios.get(url);
        return response.data; // 파일 내용을 반환
    } catch (error) {
        console.error('Error fetching raw file content:', error);
        return null;
    }
}

async function createImageUrl(url, title) {
    // 절대 경로 설정
    console.log(process.cwd());
    const outputDir = path.join(process.cwd(), 'docs', title);
    
    // Puppeteer 브라우저 실행
    const browser = await puppeteer.launch({
        headless: true,
        args: ['--no-sandbox', '--disable-setuid-sandbox'] // GitHub Actions에서 Puppeteer 실행 시 sandbox 모드 비활성화
    });
    const page = await browser.newPage();

    // User-Agent 설정
    await page.setUserAgent('Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36');

    // 해상도 설정
    await page.setViewport({
        width: 1200,
        height: 800,
        deviceScaleFactor: 2
    });

    await page.goto(url, { waitUntil: 'networkidle2' });

    // 스크린샷 저장할 폴더 생성 및 경로 설정
    fs.mkdirSync(outputDir, { recursive: true });
    const fullImagePath = path.join(outputDir, `${title}_full.jpg`);
    const imagePath = path.join(outputDir, `${title}.jpg`);

    // 전체 페이지 캡쳐
    await page.screenshot({ path: fullImagePath, fullPage: true });

    // 이미지 자르기 (위쪽 50px, 아래쪽 50px 제거)
    const cropTop = 420; // 위쪽 잘라낼 픽셀
    const cropBottom = 2400; // 아래쪽 잘라낼 픽셀

    // 이미지 크기 가져오기
    const metadata = await sharp(fullImagePath).metadata();
    
    // 자르기
    await sharp(fullImagePath)
        .extract({
            left: 0,
            top: cropTop,
            width: metadata.width,
            height: metadata.height - cropTop - cropBottom
        })
        .toFile(imagePath);

    await browser.close();

    // GitHub Pages URL 생성 및 반환
    return `https://raw.githubusercontent.com/taew0o/BOJ/main/docs/${title}/${title}.jpg`;
}
