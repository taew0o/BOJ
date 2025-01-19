import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int n = Integer.parseInt(br.readLine());
            boolean[] isOpened = new boolean[n + 1];
            Arrays.fill(isOpened, true);
            int count = n; //열려있는 방의 수
            for(int i = 2 ; i <= n ; i++){
                for(int j = i ; j <= n ; j += i){
                    isOpened[j] = !isOpened[j];
                    count += isOpened[j] ? 1 : -1;
                }
            }
            sb.append(count).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
