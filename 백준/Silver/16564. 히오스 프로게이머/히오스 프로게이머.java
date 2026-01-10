import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] levels;
    static long result = 0;
    public static long calLevelSum(long target){
        long sum = 0;
        for(int level : levels){
            sum += Math.max(0, target - level);
        }
        return sum;
    }
    public static void binarySearch(long min, long max){
        while (min <= max){
            long mid = (min + max) / 2;
            if(calLevelSum(mid) <= K){
                result = Math.max(result, mid);
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        levels = new int[N];
        for(int i = 0 ; i < N ; i++){
            levels[i] = Integer.parseInt(br.readLine());
        }
        binarySearch(1, 2_000_000_000);
        System.out.println(result);
    }
}
