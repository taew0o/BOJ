import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] point = new int[4];
        for(int i = 0 ; i < N - 2 ; i++){
            point[br.readLine().indexOf('0')]++;
        }

        int min = 4 * (N - 2);
        for(int i = 0 ; i < 4 ; i++){
            int sum = 0;
            for(int j = 0 ; j < 4 ; j++){
                if(i == j) continue;
                int diff = (Math.abs(i - j) == 3) ? 1 : Math.abs(i - j);
                sum += diff * point[j];
            }
            min = Math.min(min, sum);
        }

        System.out.println(min + N + 2);
    }
}
