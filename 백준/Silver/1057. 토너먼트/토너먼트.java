import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken());
        int round = 1;
        while (N > 1) {
            // 종료 조건 : 두 값이 인접해야 하고 작은 수가 홀수, 큰수가 짝수 여야 함
            if (Math.abs(a - b) == 1 && Math.min(a,b) % 2 == 1) {
                System.out.println(round);
                return;
            }
            if (N % 2 == 0) {
                a = (a % 2 == 0) ? a / 2 : (a + 1) / 2;
                b = (b % 2 == 0) ? b / 2 : (b + 1) / 2;
                N /= 2;
            } else {
                a = (a % 2 == 0) ? a / 2 : (a + 1) / 2;
                b = (b % 2 == 0) ? b / 2 : (b + 1) / 2;
                N = N / 2 + 1;
            }
            round++;
        }
        System.out.println(-1);
    }
}