import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n,m,t;
    public static int[] N;
    public static boolean[] knowTruth = new boolean[51];
    public static ArrayList<Integer>[] partyList;
    public static int findParent(int x){
        if(N[x] == x) return N[x];
        return N[x] = findParent(N[x]);
    }
    public static void union(int a, int b){
        int ap = findParent(a);
        int bp = findParent(b);
        if(ap != bp){
            if(knowTruth[bp]){
                int temp = ap;
                ap = bp;
                bp = temp;
            }
            N[bp] = ap;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        N = new int[n + 1];
        for(int i = 1 ; i<= n ; i++){
            N[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        if(t == 0){
            System.out.println(m);
            return;
        }
        for(int i = 0 ; i < t ; i++){
            knowTruth[Integer.parseInt(st.nextToken())] = true;
        }
        partyList = new ArrayList[m];
        for(int i = 0 ; i < m ; i++){
            partyList[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            for(int j = 1 ; j < num ; j++){
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
                partyList[i].add(y);
            }
        }
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            boolean isSafe = true;
            for(int num : partyList[i]){
                if(knowTruth[findParent(num)]){
                    isSafe = false;
                    break;
                }
            }
            count = (isSafe ? count + 1 : count);
        }
        System.out.println(count);
    }
}
