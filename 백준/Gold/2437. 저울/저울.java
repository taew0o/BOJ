import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        if (arr[0] != 1){
            System.out.println(1);
            return;
        }
        int max = 1;
        for (int i = 1 ; i < N ; i++){
            if (arr[i] > max + 1){
                System.out.println(max + 1);
                return;
            }
            max = max + arr[i];
        }
        System.out.println(max + 1);
    }
}
