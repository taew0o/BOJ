import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] planets;
    public static ArrayList<int[]> edges;
    public static int[] p;
    public static int find(int x){
        return x == p[x] ? x : (p[x] = find(p[x]));
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            p[pb] = pa;
        } else if (pb < pa) {
            p[pa] = pb;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        planets = new int[N][4];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            planets[i][0] = i;
            for(int j = 1 ; j < 4 ; j++){
                planets[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        edges = new ArrayList<>();
        //X축 정렬
        Arrays.sort(planets, (o1, o2) -> o1[1] - o2[1]);
        for(int i = 0 ; i < N - 1 ; i++){
            edges.add(new int[]{planets[i][0],  planets[i + 1][0], Math.abs(planets[i][1] - planets[i + 1][1])});
        }

        //Y축 정렬
        Arrays.sort(planets, ((o1, o2) -> o1[2] - o2[2]));
        for(int i = 0 ; i < N - 1 ; i++){
            edges.add(new int[]{planets[i][0],  planets[i + 1][0], Math.abs(planets[i][2] - planets[i + 1][2])});
        }

        //Z축 정렬
        Arrays.sort(planets, ((o1, o2) -> o1[3] - o2[3]));
        for(int i = 0 ; i < N - 1 ; i++){
            edges.add(new int[]{planets[i][0],  planets[i + 1][0], Math.abs(planets[i][3] - planets[i + 1][3])});
        }

        //parent 초기화
        p = new int[N];
        for(int i = 0 ; i < N ; i++){
            p[i] = i;
        }
        //Kruskal
        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        int count = 0;
        long sum = 0;
        for(int[] edge : edges){
            if(find(edge[0]) != find(edge[1])){
                sum += edge[2];
                union(edge[0], edge[1]);
                if(++count == N - 1) break;
            }
        }
        System.out.println(sum);
    }

}
