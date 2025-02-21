import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(queue.isEmpty()){
                    sb.append(0);
                }
                else{
                    sb.append(queue.poll());
                }
                sb.append('\n');
            }
            else{
                queue.offer(num);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
