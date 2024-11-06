import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int MAX = 200_000;

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        ArrayList<Integer> primeList = new ArrayList<>();
        for(int i = 2 ; i <= MAX ; i++){
            if(isPrime[i]){
                primeList.add(i);
                for(int j = 2 ; j * i <= 200000 ; j++){
                    isPrime[i * j] = false;
                }
            }
        }

        int len = primeList.size();
        int[] primeArr = new int[len];
        for(int i = 0 ; i < len ; i++){
            primeArr[i] = primeList.get(i);
        }

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i = 0 ; i < N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < len - N ; i++){
                int sum = 0;
                for(int j = 0 ; j < N ; j++){
                    sum += Math.abs(primeArr[j + i] - arr[j]);
                }
                min = Math.min(min, sum);
            }
            sb.append(min).append('\n');

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
