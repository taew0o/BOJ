class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        for(int i = 0 ; i < n ; i++){
            int num = name.charAt(i) - 'A'; // 0~25
            answer += Math.min(num , 26 - num);
        }
        
        int move = n - 1; // 한칸도 스킵하지 않은 경우
        for(int i = 0 ; i < n ; i++){
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            move = Math.min(move, i + n - next + Math.min(i, n - next)); // left -> mid -> right, right -> mid -> left 중 최솟값
        }
        return answer + move;
        
    }
}