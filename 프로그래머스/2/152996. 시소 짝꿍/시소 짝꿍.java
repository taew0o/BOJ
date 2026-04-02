class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] weightCount = new long[1000 + 1];
        for(int weight : weights){
            weightCount[weight] ++;
        }
        for(int i = 0 ; i <= 1000 ; i++){
            if(weightCount[i] == 0) continue;
            //1 : 1
            answer += weightCount[i] * (weightCount[i] - 1) / 2;
            //2 : 1
            if(i * 2 <= 1000){
                answer += weightCount[i] * weightCount[i * 2];
            }
            //3 : 2
            if(i % 2 == 0 && (i / 2 * 3) <= 1000){
                answer += weightCount[i]  * weightCount[i / 2 * 3];
            }
            //4 : 3
            if(i % 3 == 0 && (i / 3 * 4) <= 1000){
                answer += weightCount[i] * weightCount[i / 3 * 4];
            }
        }
        return answer;
    }
}