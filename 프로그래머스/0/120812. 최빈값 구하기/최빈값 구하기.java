class Solution {
    public int solution(int[] array) {
        int answer = -1;
        int max = 0;
        int[] count = new int[1000 + 1];
        for(int num : array){
            count[num]++;
            if(max < count[num]){
                max = count[num];
                answer = num;
            }
            else if(max == count[num]){
                answer = -1;
            }
        }
        return answer;
    }
}