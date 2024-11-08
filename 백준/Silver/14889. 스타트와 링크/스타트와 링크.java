import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] left, right;
    static int min = Integer.MAX_VALUE;
    static void dfs(int lCount, int rCount){
        if(lCount == N / 2 && rCount == N / 2){
            int lSum = 0, rSum = 0;
            for(int i = 0 ; i < N / 2 - 1 ; i++){
                for(int j = i + 1 ; j < N / 2 ; j++){
                    lSum += arr[left[i]][left[j]];
                    lSum += arr[left[j]][left[i]];
                    rSum += arr[right[i]][right[j]];
                    rSum += arr[right[j]][right[i]];
                }
            }
            min = Math.min(min, Math.abs(lSum - rSum));
            return;
        }
        if(lCount < N / 2){
            //왼쪽 팀으로 영입되는 경우
            left[lCount] = lCount + rCount;
            dfs(lCount + 1, rCount);
        }
        if(rCount < N / 2){
            //오른쪽 팀으로 영입되는 경우
            right[rCount] = lCount + rCount;
            dfs(lCount, rCount + 1);
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        left = new int[N / 2]; right = new int[N / 2];
        dfs(0,0);

        System.out.println(min);
    }
}
