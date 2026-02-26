class Solution {
    public int solution(int n, int w, int num) {
        //11, 9, 7, 5, 3, 1
        //1, 3, 5, 7 , 9, 11
        int quotient = (num - 1) / w;
        int mod = (num - 1) % w;
        int floor = quotient;
        int index = quotient % 2 == 0 ? mod : w - 1 - mod;
        int[] nextStep = new int[]{2 * (w - index) - 1, 1 + 2 * index};
        int count = 1;
        while(num + nextStep[floor % 2] <= n){
            num += nextStep[floor % 2];
            count++;
            floor++;
        }
        return count;
    }
}