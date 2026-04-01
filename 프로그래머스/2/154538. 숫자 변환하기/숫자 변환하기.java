import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        final int MAX = 1_000_000;
        int[] dist = new int[MAX + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == y) return dist[now] - 1;
            int[] next = new int[]{now + n, now * 2, now * 3};
            for(int i = 0 ; i < 3 ; i++){
                if(next[i] <= MAX && dist[next[i]] == 0){
                    dist[next[i]] = dist[now] + 1;
                    q.offer(next[i]);
                }
            }
        }
        return -1;
    }
}