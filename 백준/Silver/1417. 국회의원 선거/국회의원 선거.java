import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0);
            return;
        }
        int mine = Integer.parseInt(br.readLine());
        Queue<Integer> other = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 1 ; i < N ; i++){
            other.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (mine <= other.peek()){
            mine ++;
            other.add(other.poll() - 1);
            count++;
        }
        System.out.println(count);
    }
}
