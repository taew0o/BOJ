import java.io.*;

public class Main {
    static int N;
    static int[] result;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int depth){
        if(depth == N){
            for(int n : result){
                sb.append(n + 1).append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i = 0 ; i < N ; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        result = new int[N];
        isVisited = new boolean[N];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
