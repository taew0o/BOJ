import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<String>[] queues = new Queue[N];
        for(int i = 0 ; i < N ; i++){
            queues[i] = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                queues[i].offer(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            String word = st.nextToken();
            boolean flag = false;
            for(int i = 0 ; i < N ; i++){
                if(!queues[i].isEmpty() && queues[i].peek().equals(word)){
                    queues[i].poll();
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Impossible");
                return;
            }
        }
        for(int i = 0 ; i < N ; i++){
            if(!queues[i].isEmpty()){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
