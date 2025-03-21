import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        String[] rMap = new String[R], cMap = new String[C];
        Arrays.fill(cMap, "");
        for(int i = 0 ; i < R ; i++){
            rMap[i] = br.readLine();
            for(int j = 0 ; j < C ; j++){
                cMap[j] += rMap[i].charAt(j);
            }
        }

        for(int i = 0 ; i < R ; i++){
            if(rMap[i].contains("SW") || rMap[i].contains("WS")){
                System.out.println(0);
                return;
            }
        }

        for(int i = 0 ; i < C ; i++){
            if(cMap[i].contains("SW") || cMap[i].contains("WS")){
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
        //모든 빈칸 울타리로 바꿔서 출력하기
        for(int i = 0 ; i < R ; i++){
            sb.append(rMap[i].replaceAll("\\.", "D")).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
