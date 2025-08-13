import java.util.*;

class Solution {
    public long binarySearch(int n, int[] times){
        long result = Long.MAX_VALUE;
        long left = 1, right = (long) Math.pow(1_000_000_000, 2);
        while(left <= right){
            long mid = (left + right) / 2;
            long count = calCount(mid, times);
            if(count >= n){
                result = Math.min(result, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
    public long calCount(long t, int[] times){
        long result = 0;
        for(int time : times){
            result += t / time;
        }
        return result;
    }
    public long solution(int n, int[] times) {
        return binarySearch(n, times);
    }
}