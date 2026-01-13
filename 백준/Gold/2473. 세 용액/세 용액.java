import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long minAbsSum = 3_000_000_000L;
        int[] result = new int[3];
        for(int i = 0 ; i < N - 2 ; i++){
            int left = i + 1, right = N - 1;
            while (left < right){
                long sum = (long) arr[i] + arr[left] + arr[right];
                if(Math.abs(sum) < minAbsSum){
                    minAbsSum = Math.abs(sum);
                    result[0] = arr[i]; result[1] = arr[left]; result[2] = arr[right];
                }
                if (sum == 0){
                    break;
                } else if(sum < 0){
                    left++;
                } else{
                    right--;
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
