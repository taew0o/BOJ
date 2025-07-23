import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; i++){
                D[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i <= N ; i++){
                graph.add(new ArrayList<>());
            }

            int[] remain = new int[N + 1]; //해당 번호의 건물이 지어지기 위해 남은 완성되지 않은 건물의 수
            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                remain[y]++;
            }

            int[] dp = new int[N + 1];
            Queue<Integer> available = new LinkedList<>(); //건축 가능한 건물 번호
            for(int i = 1 ; i <= N ; i++){
                if(remain[i] == 0){
                    dp[i] = D[i];
                    available.offer(i);
                }
            }

            int target = Integer.parseInt(br.readLine());
            while (!available.isEmpty()){
                int now = available.poll();
                if(now == target){
                    break;
                }
                for (int i = 0 ; i < graph.get(now).size() ; i++){
                    int next = graph.get(now).get(i);
                    dp[next] = Math.max(dp[next], dp[now] + D[next]);
                    if (--remain[next] == 0){
                        available.offer(next);
                    }
                }
            }
            sb.append(dp[target]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
