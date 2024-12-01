import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());
 
        int sqrtB = (int)Math.sqrt(B);

        boolean[] isPrime = new boolean[sqrtB + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i = 2 ; i <= sqrtB ; i++){
            if(isPrime[i]){
                for(int j = 2 ; i * j <= sqrtB ; j++){
                    isPrime[i * j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2 ; i <= sqrtB ; i++){
            if(isPrime[i]){
                long almostPrime = i;
                while (almostPrime <= (double) B / i){
                    if(almostPrime >= (double) A / i){
                        count++;
                    }
                    almostPrime *= i;
                }
            }
        }

        System.out.println(count);
    }
}
