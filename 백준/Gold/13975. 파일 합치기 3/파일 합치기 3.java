import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Long> files = new PriorityQueue<>();
            for(int i = 0 ; i < K ; i++){
                files.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (files.size() > 2){
                long newFile = files.poll() + files.poll();
                sum += newFile;
                files.offer(newFile);
            }
            sum += files.poll() + files.poll();
            sb.append(sum).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
