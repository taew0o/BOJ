import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int MAX = 65536;
    static int houseR, houseC, destR, destC;
    static int[] storeR, storeC;
    static boolean isStoreVisited[];
    public static String bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{houseR, houseC});
        isStoreVisited = new boolean[N];
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(Math.abs(now[0] - destR) + Math.abs(now[1] - destC) <= 1000){
                return "happy";
            }
            for(int i = 0 ; i < N ; i++){
                if(!isStoreVisited[i] && Math.abs(now[0] - storeR[i]) + Math.abs(now[1] - storeC[i]) <= 1000){
                    isStoreVisited[i] = true;
                    queue.offer(new int[]{storeR[i], storeC[i]});
                }
            }
        }
        return "sad";
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            houseC = Integer.parseInt(st.nextToken()); houseR = Integer.parseInt(st.nextToken());
            storeC = new int[N]; storeR = new int[N];
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                storeC[i] = Integer.parseInt(st.nextToken());
                storeR[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            destC = Integer.parseInt(st.nextToken()); destR = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
