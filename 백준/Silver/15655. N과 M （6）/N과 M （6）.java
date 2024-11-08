import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int index, int depth){
        if(depth == M){
            for(int num : result){
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }
        //나머지를 모두 선택 했을 때 N개를 선택할 수 있을때만 추가로 탐색
        if(N - index >= M - depth){
            for(int i = index ; i < N ; i++){
                result[depth] = arr[i];
                dfs(i + 1, depth + 1);
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[M];
        dfs(0,0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
