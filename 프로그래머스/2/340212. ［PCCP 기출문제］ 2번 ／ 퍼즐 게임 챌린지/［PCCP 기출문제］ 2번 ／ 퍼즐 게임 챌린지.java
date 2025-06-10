class Solution {
    public static int calTime(int diff, int level, int time_cur, int time_prev){
        if(diff <= level){
            return time_cur;
        }
        return (diff - level) * (time_cur + time_prev) + time_cur;
    }
    public static long calAllTime(int[] diffs, int[] times, int level){
        long sum = times[0];
        for(int i = 1 ; i < diffs.length ; i++){
            sum += calTime(diffs[i], level, times[i], times[i - 1]);
        }
        return sum;
    }
    public static int binarySearch(int[] diffs, int[] times, long limit, int left, int right){
        int result = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left + right) / 2;
            if(calAllTime(diffs, times, mid) <= limit){
                result = Math.min(result, mid);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs, times, limit, 1, 100_000);
    }
}