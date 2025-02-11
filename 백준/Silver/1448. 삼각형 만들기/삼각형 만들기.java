import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] len = new int[N];
        for(int i = 0 ; i < N ; i++){
            len[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(len);
        for(int i = N - 1 ; i > 1; i--){
            if(len[i] < len[i - 1] + len[i - 2]){
                System.out.println(len[i] + len[i - 1] + len[i - 2]);
                return;
            }
        }

        System.out.println(-1);
    }
}
