import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N,M,K;
    public static int[] candy, p, groupCandy, groupChild;
    public static int find(int x){
        return x == p[x] ? x : (p[x] = find(p[x]));
    }
    public static void union(int a, int b){
        int pa =  find(a);
        int pb = find(b);
        if(pa == pb)
            return;
        if(pa > pb){
            int temp = pb;
            pb = pa;
            pa = temp;
        }
        p[pb] = pa;
        groupChild[pa] += groupChild[pb];
        groupCandy[pa] += groupCandy[pb];
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candy = new int[N + 1]; p =  new int[N + 1];
        groupCandy = new int[N + 1]; groupChild = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            candy[i] = Integer.parseInt(st.nextToken());
            p[i] = i;
            groupChild[i] = 1;
            groupCandy[i] = candy[i];
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken()),b =  Integer.parseInt(st.nextToken());
            union(a, b);
        }
        ArrayList<int[]> groups = new ArrayList<>();
        for(int i = 1 ; i <= N ; i ++){
            if(p[i] == i){
                groups.add(new int[]{groupChild[i], groupCandy[i]});
            }
        }

        int[] dp = new int[K];
        for(int[] group : groups){
            int cost = group[0], value = group[1];
            for(int i = K - 1 ; i >= cost ; i--){
                dp[i] = Math.max(dp[i], dp[i - cost] + value);
            }
        }
        int result = 0;
        for(int i = 0 ; i < K ; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }

}
