import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());

            boolean[][] dp = new boolean[N + 1][7];
            dp[0][1] = true;

            for(int i = 1 ; i <= N ; i++){
                String info = br.readLine();
                char oper1 = info.charAt(0), oper2 = info.charAt(4);
                int num1 = info.charAt(2) - '0', num2 = info.charAt(6) - '0';
                for(int j = 0 ; j < 7 ; j++){
                    if(dp[i - 1][j]){
                        if(oper1 == '+'){
                            dp[i][(j + num1) % 7] = true;
                        }
                        else{
                            dp[i][(j * num1) % 7] = true;
                        }
                        if(oper2 == '+'){
                            dp[i][(j + num2) % 7] = true;
                        }
                        else{
                            dp[i][(j * num2) % 7] = true;
                        }
                    }
                }
            }

            sb.append(dp[N][0] ? "LUCKY" : "UNLUCKY").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
