import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static long binarySearch(int left, int right, int target){
        long count = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target * 0.9){
                count += right - mid + 1;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return count;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long count = 0;
        for(int i = 1 ; i < N ; i++){
            count += binarySearch(0, i - 1, arr[i]);
        }
        System.out.println(count);
    }
}
