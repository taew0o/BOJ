import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] arr;
    static long minSum;
    static int[] result;
    public static long[] binarySearch(int left, int right){
        long[] result = new long[]{-1, Long.MAX_VALUE}; //인덱스, 최소 합
        int l = left + 1, r = right - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            long sum = arr[left] + arr[mid] + arr[right];
            if(sum == 0) {
                result[0] = mid; result[1] = 0;
                break;
            }else if (result[1] > Math.abs(sum)){
                result[0] = mid;
                result[1] = Math.abs(sum);
            }
            if(sum > 0){
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return result;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        minSum = Long.MAX_VALUE;
        result = new int[3];
        for(int i = 0 ; i < N - 2 ; i++){
            for(int j = N - 1 ; j > i + 1 ; j--){
                long[] now = binarySearch(i, j);
                int mid = (int) now[0];
                long sum = now[1];
                if(sum == 0){
                    System.out.println(arr[i] + " " + arr[mid] + " " + arr[j]);
                    return;
                } else if(minSum > sum){
                    minSum = sum;
                    result[0] = i; result[1] = mid; result[2] = j;
                }
            }
        }
        System.out.println(arr[result[0]] + " " + arr[result[1]] + " " + arr[result[2]]);
    }
}
