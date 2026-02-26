class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int N = players.length;
        int[] servers = new int[N];
        for(int i = 0 ; i < N ; i++){
            int neededServer = players[i] / m;
            if(neededServer > servers[i]){
                answer += neededServer - servers[i];
                for(int j = i + 1 ; j < Math.min(N, i + k) ; j++){
                    servers[j] += neededServer - servers[i];
                }
            }
        }
        return answer;
    }
}