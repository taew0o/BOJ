import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        if(N <= K){
            System.out.println(N);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] count = new int[100_000 + 1];
        for(int i = 0 ; i < K ; i++){
            count[arr[i]]++;
        }

        int max = K;
        int left = 0, right = K - 1;
        while (right < N - 1){
            right++;
            if(++count[arr[right]] > K){
                while (count[arr[right]] > K){
                    count[arr[left]]--;
                    left++;
                }
            }
            max =  Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
