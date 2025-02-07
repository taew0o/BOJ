import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()),
                L = Integer.parseInt(st.nextToken());

        int[] weight = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < W ; i++){
            queue.offer(0);
        }

        int time = 0;
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            time++;
            sum -= queue.poll();
            if(sum + weight[i] > L){
                queue.offer(0);
                i--;
                continue;
            }
            sum += weight[i];
            queue.add(weight[i]);
        }
        while (!queue.isEmpty()){
            queue.poll();
            time++;
        }

        System.out.println(time);
    }
}
