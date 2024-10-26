import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,L,W,H;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        double left = 0;
        double right = Math.min(L,Math.min(W,H));
        double mid;
        while (left < right) {
            mid = (left + right) / 2;
            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) < N) {
                if (right == mid) break;
                right = mid;
            } else {
                if (left == mid) break;
                left = mid;
            }
        }
        System.out.println(left);

    }
}
