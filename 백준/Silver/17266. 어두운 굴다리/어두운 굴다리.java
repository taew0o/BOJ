import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] x;
    static boolean isAvailable(int height){
        if(x[0] - height > 0) return false;
        for(int i = 1 ; i < M ; i++){
            if(x[i] - height > x[i - 1] + height) return false;
        }
        return x[M - 1] + height >= N;
    }
    static int binarySearch(int left, int right){
        int min = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left + right) / 2;
            if(isAvailable(mid)){
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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        x = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(0, N));
    }
}
