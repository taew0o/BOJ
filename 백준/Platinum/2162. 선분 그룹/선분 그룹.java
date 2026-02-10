import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] coords;
    public static int[] p, counts;
    public static int find(int x){
        return x == p[x] ? x : (p[x] = find(p[x]));
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            counts[pa] += counts[pb];
            counts[pb] = 0;
            p[pb] = pa;
        } else if(pa > pb){
            counts[pb] += counts[pa];
            counts[pa] = 0;
            p[pa]= pb;
        }
    }
    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3){
        int res = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        return Integer.compare(res, 0);
    }
    public static boolean isCrossed(int[] coord1, int[] coord2){
        int x1 = coord1[0], y1 = coord1[1], x2 = coord1[2], y2 = coord1[3];
        int x3 = coord2[0], y3 = coord2[1], x4 = coord2[2], y4 = coord2[3];
        int abc = ccw(x1, y1, x2, y2, x3, y3), abd = ccw(x1, y1, x2, y2, x4, y4),
                cda = ccw(x3, y3, x4, y4, x1, y1), cdb = ccw(x3, y3, x4, y4, x2, y2);
        int res1 = abc * abd, res2 = cda * cdb;
        if(res1 <= 0 && res2 <= 0){
            if(res1 == 0 && res2 == 0){
                int minX1 = Math.min(x1, x2), maxX1 = Math.max(x1, x2), minY1 = Math.min(y1, y2), maxY1 = Math.max(y1, y2);
                int minX2 = Math.min(x3, x4), maxX2 = Math.max(x3, x4), minY2 = Math.min(y3, y4), maxY2 = Math.max(y3, y4);
                return minX1 <= maxX2 && minX2 <= maxX1 && minY1 <= maxY2 && minY2 <= maxY1;
            } else{
                return true;
            }
        } else{
            return false;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coords = new int[N][4];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++){
                coords[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        p = new int[N];
        for(int i = 0 ; i < N ; i++){
            p[i] = i;
        }
        counts = new int[N];
        Arrays.fill(counts, 1);
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(isCrossed(coords[i], coords[j]) && find(i) != find(j)){
                    union(i, j);
                }
            }
        }
        int groupCount = 0, maxGroupSize = 0;
        for(int i = 0 ; i < N ; i++){
            if(p[i] == i){
                groupCount++;
                maxGroupSize = Math.max(maxGroupSize, counts[i]);
            }
        }
        System.out.println(groupCount);
        System.out.println(maxGroupSize);
    }
}
