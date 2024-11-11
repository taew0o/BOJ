import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] frogs = new int[N];
        for(int i = 0 ; i < N ; i++){
            frogs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE , frogNum = -1;
        for(int i = 0 ; i < N ; i++){
            int dist = Math.abs(S - frogs[i]);
            int cost;
            if(dist >= 2 * K){
                cost = (dist - 2 * K) * L;
            }
            else{
                cost = 2 * K - dist;
            }
            if(cost < min){
                min = cost;
                frogNum = i + 1;
            }
        }
        System.out.println(min + " " + frogNum);
    }
}
