import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int G,P;
    static int[] parent;
    static int find(int x){
        return x ==  parent[x] ? x : (parent[x] = find(parent[x]));
    }
    static void union(int a,int b){
        int x = find(a);
        int y = find(b);
        if(x < y){
            parent[y] = x;
        } else if(x > y){
            parent[x] = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for(int i = 1; i <= G; i++){
            parent[i] = i;
        }
        int count = 0;
        while(P --> 0){
            int next = find(Integer.parseInt(br.readLine()));
            if(next == 0){
                System.out.println(count);
                return;
            }
            union(next, next - 1);
            count++;
        }
        System.out.println(count);
    }
}
