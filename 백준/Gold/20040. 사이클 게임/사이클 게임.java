import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] p;
    public static int find(int a){
        return a == p[a] ? a : (p[a] = find(p[a]));
    }
    public static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if(pa == pb) return;
        if(pa < pb){
            p[pb] = pa;
        }else{
            p[pa] = pb;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N];
        for(int i = 0; i < N; i++){
            p[i] = i;
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                System.out.println(i);
                return;
            }
            union(a, b);
        }
        System.out.println(0);
    }

}
