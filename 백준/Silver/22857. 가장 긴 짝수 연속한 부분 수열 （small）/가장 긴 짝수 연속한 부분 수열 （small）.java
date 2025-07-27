import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0 , right = 0;
        int oddCount = 0, evenCount = 0;
        if (arr[0] % 2 == 0){
            evenCount++;
        }
        else{
            oddCount++;
        }
        
        int result = evenCount;
        while (left <= right){
            if (oddCount > K){
                if (arr[left] % 2 == 0){
                    evenCount--;
                }
                else{
                    oddCount--;
                }
                left++;
            }
            else{
                right++;
                if(right >= N) break;
                if(arr[right] %2 == 0){
                    evenCount++;
                }
                else{
                    oddCount++;
                }
                result = Math.max(result, evenCount);
            }
        }
        System.out.println(result);
    }
}
