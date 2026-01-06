import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(L);
        if(L[0] >= N - 1) {
            System.out.println(N - 1);
            return;
        }
        int excludeCount = 0;
        for(int i = 0 ; i < N ; i ++){
            if(excludeCount + L[i] >= N - i - 1) {
                System.out.println(N - i - 1);
                return;
            }
            excludeCount += L[i];
        }
    }
}
