import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] P;
    public static int find(int a){
        return a == P[a] ? a : (P[a] = find(P[a]));
    }
    public static void union(int a, int b){
        int pa = find(a), pb = find(b);
        P[pb] = pa;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());

        P = new int[N];
        for(int i = 0 ; i < N ; i++){
            P[i] = i;
        }

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i, j);
                }
            }
        }

        int[] plans = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 1 ; i < M ; i++){
            if(find(plans[0] - 1) != find(plans[i] - 1)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
