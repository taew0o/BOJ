import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) , S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        //모두 더해도 S를 만들 수 없는 경우
        if(sum[N] < S){
            System.out.println(0);
            return;
        }

        int left = 0, right = 1;
        int min = N;
        while (left != right && right <= N){
            if(sum[right] - sum[left] >= S){
                min = Math.min(right - left, min);
                left++;
            }
            else{
                right++;
            }
        }
        System.out.println(min);
    }
}
