import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[N];
        Arrays.fill(result, 100_000);

        result[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i = now + 1 ; i <= Math.min(N - 1, now + map[now]) ; i++){
                if(result[i] > result[now] + 1){
                    result[i] = result[now] + 1;
                    queue.offer(i);
                }
            }
        }

        System.out.println(result[N - 1] == 100_000 ? -1 : result[N - 1]);
    }
}
