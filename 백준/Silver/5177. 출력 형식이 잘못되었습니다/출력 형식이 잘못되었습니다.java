import java.io.*;

public class Main {
    public static boolean isSameForm(String str1, String str2){
        //앞 뒤 공백 제거
        str1 = str1.trim();
        str2 = str2.trim();
        
        //대소문자 구분 x
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        //공백 크기 구분 x
        str1 = str1.replaceAll("\\s+" , " ");
        str2 = str2.replaceAll("\\s+" , " ");
        
        //특수부호 바로 앞, 뒤 공백 제거
        str1 = str1.replaceAll("\\s?([()\\[\\]{}.,;:])\\s?" , "$1");
        str2 = str2.replaceAll("\\s?([()\\[\\]{}.,;:])\\s?" , "$1");
        
        //여는 괄호
        str1 = str1.replaceAll("[(\\[]", "{");
        str2 = str2.replaceAll("[(\\[]" ,"{");
        
        //닫는 괄호
        str1 = str1.replaceAll("[)\\]]", "}");
        str2 = str2.replaceAll("[)\\]]", "}");
        
        //쉼표 , 세미 콜론 구분
        str1 = str1.replaceAll(";" ,",");
        str2 = str2.replaceAll(";", ",");

        return str1.equals(str2);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= K ; i++){
            sb.append(String.format("Data Set %d: %s", i, isSameForm(br.readLine(), br.readLine()) ? "equal" : "not equal")).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
