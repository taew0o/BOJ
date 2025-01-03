import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1){
            System.out.println(arr[0] == M ? 1 : 0);
            return;
        }
        int sum = arr[0] + arr[1], count = arr[0] == M ? 1 : 0;
        int left = 0, right = 1;
        while (true){
            if(sum > M){
                sum -= arr[left];
                left++;
            }
            else{
                if(sum == M){
                    count++;
                }
                right++;
                if(right == N) break;
                sum += arr[right];
            }
        }
        System.out.println(count);
    }
}
