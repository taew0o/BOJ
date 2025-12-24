import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] ice = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int g =  Integer.parseInt(st.nextToken()), x =  Integer.parseInt(st.nextToken());
            ice[i][0] = x;
            ice[i][1] = g;
        }
        Arrays.sort(ice, (o1, o2) -> o1[0] - o2[0]);
        int[] sum = new int[N + 1];
        sum[1] = ice[1][1];
        for (int i = 2; i <= N; i++) {
            sum[i] = sum[i - 1] + ice[i][1];
        }
        int length =  2 * K + 1;
        if(length > ice[N][0]){
            System.out.println(sum[N]);
            return;
        }
        int left = 1, right = 1, max = 0;
        while (right <= N){
            if(ice[right][0] - ice[left][0] + 1 <= length){
                max = Math.max(max, sum[right] - sum[left - 1]);
                right++;
            }
            else{
                left ++;
            }
        }
        System.out.println(max);
    }
}
