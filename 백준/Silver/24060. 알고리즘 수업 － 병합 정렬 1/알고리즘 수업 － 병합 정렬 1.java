import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K, count;
    static int[] arr, temp;
    public static void mergeSort(int p, int r){
        if(p < r){
            int q = (p+r)/2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }
    public static void merge(int p, int q, int r){
        temp = new int[r - p + 1];
        int i = p, j = q + 1, t = 0;
        while (i <= q && j <= r){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            } else{
                temp[t++] = arr[j++];
            }
        }
        while(i <= q){
            temp[t++] = arr[i++];
        }
        while(j <= r){
            temp[t++] = arr[j++];
        }
        i = p; t = 0;
        while(i <= r){
            arr[i++] = temp[t++];
            if(++count == K){
                System.out.println(arr[i - 1]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mergeSort(0, N - 1);
        if(count < K){
            System.out.println(-1);
        }
    }
}
