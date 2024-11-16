import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long binarySearch(long N){
        long left = 1, right = 2_000_000_000;
        long min = right;
        while (left <= right){
            long mid = (left + right) / 2;
            if(N <= 3 * mid * (mid - 1) + 1){
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return min;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long N = Long.parseLong(br.readLine());

        if(N == 1){
            System.out.println(1);
            return;
        }
        System.out.println(binarySearch(N));
    }
}
