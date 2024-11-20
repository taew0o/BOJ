import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken()),
                U = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());

        int[] visited = new int[F + 1];
        visited[S] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        while (!queue.isEmpty()){
            int now = queue.poll();
            if(now == G){
                System.out.println(visited[now] - 1);
                return;
            }
            if(1 <= now + U && now + U <= F && visited[now + U] == 0){
                visited[now + U] = visited[now] + 1;
                queue.offer(now + U);
            }
            if(1 <= now - D && now - D <= F && visited[now - D] == 0){
                visited[now - D] = visited[now] + 1;
                queue.offer(now - D);
            }
        }
        System.out.println("use the stairs");
    }
}
