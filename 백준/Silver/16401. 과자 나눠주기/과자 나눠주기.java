import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] snacks;
    static int max = 0;
    public static long calCount(int len){
        long count = 0;
        for(int snack : snacks){
            count += snack / len;
        }
        return count;
    }
    public static void binarySearch(int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            if(calCount(mid) < M){
                right = mid - 1;
            }
            else{
                max = Math.max(max, mid);
                left = mid + 1;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());

        snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(snacks);

        binarySearch(1, snacks[N - 1]);

        System.out.println(max);
    }
}
