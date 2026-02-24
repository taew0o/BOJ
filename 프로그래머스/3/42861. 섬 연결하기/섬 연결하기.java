import java.util.*;
class Solution {
    static int N;
    static int[] p;
    static int find(int a){
        return a == p[a] ? a : (p[a] = find(p[a]));
    }
    static void union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa < pb){
            p[pb] = pa;
        } else if(pb < pa){
            p[pa] = pb;
        }
    }
    public int solution(int n, int[][] costs) {
        N = n;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        p = new int[N];
        for(int i = 0 ; i < N ; i++){
            p[i] = i;
        }

        int count = 0, sum = 0;
        for(int[] edge : costs){
            int a = edge[0], b = edge[1], cost = edge[2];
            if(find(a) != find(b)){
                union(a, b);
                sum += cost;
                count++;
                if(count == N - 1) break;
            }
        }
        return sum;
    }
}