import java.util.*;
class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(int node : nodes){
            adj.put(node, new ArrayList<>());
            degree.put(node, 0);
        }
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            degree.put(a, degree.get(a) + 1);
            degree.put(b, degree.get(b) + 1);
        }
        Set<Integer> visited = new HashSet<>();
        int trees = 0, reverseTrees = 0;
        for(int node : nodes){
            if(!visited.contains(node)){
                Queue<Integer> q = new LinkedList<>();
                q.offer(node);
                visited.add(node);
                int root = 0, reverse = 0;
                while(!q.isEmpty()){
                    int now = q.poll();
                    int d = degree.get(now);
                    
                    if(now % 2 == d % 2) root++;
                    else reverse++;
                    
                    for(int next : adj.get(now)){
                        if(!visited.contains(next)){
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
                if(root == 1) trees++;
                if(reverse == 1) reverseTrees++;
            }
        }
        return new int[]{trees, reverseTrees};
    }
}