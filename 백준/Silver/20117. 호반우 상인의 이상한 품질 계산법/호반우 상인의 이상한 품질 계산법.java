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

        int sum = 0;
        int start = N % 2 == 0 ? N / 2 : N / 2 + 1;

        for(int i = start ; i < N ; i++){
            sum += arr[i] * 2;
        }

        if(N % 2 != 0){
            sum += arr[N / 2];
        }

        System.out.println(sum);
    }
}
