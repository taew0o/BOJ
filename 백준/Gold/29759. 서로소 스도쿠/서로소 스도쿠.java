import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //에라토스테네스의 체로 소수 집합 만들기
        final int MAX = 1_000_000;
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        HashSet<Integer> primes = new HashSet<>();
        for(int i = 2 ; i <= MAX ; i++){
            if(isPrime[i]){
                primes.add(i);
                for(int j = 2 ; i * j <= MAX ; j++){
                    isPrime[i * j] = false;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N * N][N * N];
        for(int i = 0 ; i < N * N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N * N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(isPrime[arr[i][j]]){
                    primes.remove(arr[i][j]);
                }
            }
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue.addAll(primes);
        for(int i = 0 ; i < N * N ; i++){
            for(int j = 0 ; j < N * N ; j++){
                sb.append(arr[i][j] == 0 ? queue.poll() : arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
