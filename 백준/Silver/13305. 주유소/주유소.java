import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] road = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N - 1 ; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = Integer.MAX_VALUE;
        long sum = 0;
        for(int i = 0 ; i < N - 1 ; i++){
            minPrice = Math.min(minPrice, price[i]);
            sum += minPrice * road[i];
        }

        System.out.println(sum);
    }
}
