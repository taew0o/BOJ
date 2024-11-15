import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
                k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i = 0 ; i < N ; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer,Integer> now = new HashMap<>();
        for(int i = N - k + 1 ; i < N ; i++){
            now.put(sushi[i], now.getOrDefault(sushi[i],0) + 1);
        }
        now.put(sushi[0], now.getOrDefault(sushi[0], 0) + 1);

        int max = now.getOrDefault(c, 0) == 0 ? now.size() + 1 : now.size();
        for(int right = 1 ; right < N ; right++) {
            int left = (right + N - k) % N;
            if(now.get(sushi[left]) == 1){
                now.remove(sushi[left]);
            }
            else{
                now.put(sushi[left], now.get(sushi[left]) - 1);
            }
            now.put(sushi[right], now.getOrDefault(sushi[right], 0) + 1);
            max = Math.max(max, now.getOrDefault(c, 0) == 0 ? now.size() + 1 : now.size());
        }

        System.out.println(max);
    }
}
