import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int MAX = 250_000;
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for(int i = 2 ; i <= MAX ; i++){
            if(isPrime[i]){
                primeList.add(i);
                for(int j = 2 * i ; j <= MAX ; j += i){
                    isPrime[j] = false;
                }
            }
        }

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int count = 0;
            for(int prime : primeList){
                if(n < prime && prime <= 2 * n) count++;
                else if(prime > 2 * n) break;
            }
            sb.append(count).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
