class Solution {
    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int[] answer = new int[]{0, N - 1};
        
        int left = 0, right = 0;
        int sum = sequence[0];
        while(left <= right){
            if(sum <= k){
                if(sum == k && answer[1] - answer[0] > right - left){
                    answer[0] = left;
                    answer[1] = right;
                }
                if(right == N - 1) break;
                sum += sequence[++right];
            }
            else{
                sum -= sequence[left++];
            }
        }
        return answer;
    }
}