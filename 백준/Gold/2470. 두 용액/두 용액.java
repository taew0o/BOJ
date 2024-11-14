import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int result = 2_000_000_000;
    static int min = -1, max = -1;
    static void binarySearch(int now, int left, int right){
        if(left > right) return;
        int mid = (left + right) / 2;
        if(now == mid) return;
        if(Math.abs(arr[now] + arr[mid]) < Math.abs(result)){
            result = arr[now] + arr[mid];
            min = Math.min(arr[now], arr[mid]);
            max = Math.max(arr[now], arr[mid]);
            binarySearch(now, left, mid - 1);
            binarySearch(now, mid + 1, right);
        }
        else{
            if(arr[now] + arr[mid] > result){
                binarySearch(now, left, mid - 1);
            }
            else{
                binarySearch(now, mid + 1, right);
            }
        }
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
        for(int i = 0 ; i < N ; i++){
            binarySearch(i, 0, N - 1);
        }
        System.out.println(min + " " + max);
    }
}
