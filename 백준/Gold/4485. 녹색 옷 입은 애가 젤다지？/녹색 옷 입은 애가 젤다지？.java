import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    static int dijkstra(){
        //int[] = 행,열,cost
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.offer(new int[]{0,0,map[0][0]});

        int[][] cost = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(cost[i], 1_000_000);
        }
        cost[0][0] = map[0][0];

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[2] > cost[now[0]][now[1]]) continue;
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < N &&
                        cost[nr][nc] > cost[now[0]][now[1]] + map[nr][nc]){
                    cost[nr][nc] = cost[now[0]][now[1]] + map[nr][nc];
                    queue.offer(new int[]{nr, nc, cost[nr][nc]});
                }
            }
        }
        return cost[N - 1][N - 1];
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            for(int i = 0 ; i < N ; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            sb.append(String.format("Problem %d: %d", index, dijkstra())).append('\n');
            index++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
