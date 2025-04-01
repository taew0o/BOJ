import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int[] dist = new int[N - 1];
        for(int i = 0 ; i < N - 1 ; i ++){
            dist[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(dist);
        long sum = 0;
        for(int i = 0 ; i < N - K ; i++){
            sum += dist[i];
        }

        System.out.println(sum);

    }
}
