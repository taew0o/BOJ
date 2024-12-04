import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());

            int[] graph = new int[N + 1];
            for(int i = 1 ; i <= N ; i++){
                graph[i] = Integer.parseInt(br.readLine());
            }

            boolean[] isVisited = new boolean[N + 1];
            isVisited[1] = true;
            int now = 1;
            int count = 0;
            while (true){
                int next = graph[now];
                count++;
                if(next == N){
                    sb.append(count).append('\n');
                    break;
                }
                if(isVisited[next]){
                    sb.append(0).append('\n');
                    break;
                }
                now = next;
                isVisited[now] = true;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
