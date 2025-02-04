import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        boolean[] isPerson = new boolean[N], isEaten = new boolean[N];
        String str = br.readLine();
        for(int i = 0 ; i < N ; i++){
            isPerson[i] = str.charAt(i) == 'P';
        }

        int result = 0;
        for(int i = 0 ; i < N ; i++){
            if(isPerson[i]){
                for(int j = Math.max(0, i - K) ; j < Math.min(N, i + K + 1) ; j++){
                    if(!isPerson[j] && !isEaten[j]){
                        result++;
                        isEaten[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
