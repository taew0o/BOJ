import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] operNum;
    static int min,max;
    public static void dfs(int num, int depth){
        if(depth == N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        if(operNum[0] > 0){
            operNum[0]--;
            dfs(num + arr[depth], depth + 1);
            operNum[0]++;
        }
        if(operNum[1] > 0){
            operNum[1]--;
            dfs(num - arr[depth], depth + 1);
            operNum[1]++;
        }
        if(operNum[2] > 0){
            operNum[2]--;
            dfs(num * arr[depth], depth + 1);
            operNum[2]++;
        }
        if(operNum[3] > 0){
            operNum[3]--;
            dfs(num / arr[depth], depth + 1);
            operNum[3]++;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operNum = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            operNum[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
}
