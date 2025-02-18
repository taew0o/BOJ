import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] fibbo = new int[D + 1];
        fibbo[1] = 1; fibbo[2] = 1;
        for(int i = 3 ; i <= D ; i++){
            fibbo[i] = fibbo[i - 2] + fibbo[i - 1];
        }
        int now = fibbo[D];
        if(now == K){
            System.out.println(1);
            System.out.println(1);
            return;
        }
        for(int b = 1 ; b <= K ; b++){
            now = fibbo[D] + fibbo[D - 1] * (b - 1);
            if(now == K){
                System.out.println(1);
                System.out.println(b);
                return;
            }
            for(int a = 2 ; a <= b ; a++){
                now += fibbo[D - 2];
                if(now == K){
                    System.out.println(a);
                    System.out.println(b);
                    return;
                }
            }
        }

    }
}
