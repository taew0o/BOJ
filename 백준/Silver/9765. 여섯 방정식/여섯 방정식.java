import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long gcd(long a, long b){
        while (b != 0){
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long C[] = new long[6 + 1];
        for(int i = 1;  i <= 6 ; i++){
            C[i] = Long.parseLong(st.nextToken());
        }

        long x2 = gcd(C[1], C[5]);
        sb.append(C[1] / x2).append(" ").append(x2).append(" ").append(C[5] / x2).append(" ");

        long x6 = gcd(C[3], C[6]);
        sb.append(C[6] / x6).append(" ").append(x6).append(" ").append(C[3] / x6);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
