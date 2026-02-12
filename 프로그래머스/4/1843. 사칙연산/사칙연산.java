import java.util.*;
class Solution {
    static int[] nums;
    static boolean[] opers;
    static int[][] minDp, maxDp;
    static int minDP(int left, int right){
        if(left == right) return minDp[left][right] = nums[left];
        if(minDp[left][right] != -1) return minDp[left][right];
        int result = Integer.MAX_VALUE;
        for(int i = left ; i < right ; i++){
            int leftPart = minDP(left, i);
            int rightPart = opers[i] ? minDP(i + 1, right) : maxDP(i + 1, right);
            result = Math.min(result, opers[i] ? leftPart + rightPart : leftPart - rightPart);
        }
        return minDp[left][right] = result;
    }
    static int maxDP(int left, int right){
        if(left == right) return maxDp[left][right] = nums[left];
        if(maxDp[left][right] != -1) return maxDp[left][right];
        int result = Integer.MIN_VALUE;
        for(int i = left ; i < right ; i++){
            int leftPart = maxDP(left, i);
            int rightPart = opers[i] ? maxDP(i + 1, right) : minDP(i + 1, right);
            result = Math.max(result, opers[i] ? leftPart + rightPart : leftPart - rightPart);
        }
        return maxDp[left][right] = result;
    }
    public int solution(String arr[]) {
        nums = new int[arr.length / 2 + 1];
        opers = new boolean[arr.length / 2];
        for(int i = 0 ; i < arr.length ; i += 2){
            nums[i / 2] = Integer.parseInt(arr[i]);
        }
        for(int i = 1 ; i < arr.length ; i += 2){
            opers[(i - 1) / 2] = arr[i].equals("+"); //+면 true , 아니면 false
        }
        minDp = new int[nums.length][nums.length];
        maxDp = new int[nums.length][nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            Arrays.fill(minDp[i], -1);
            Arrays.fill(maxDp[i], -1);
        }
        maxDP(0, nums.length - 1);
        return maxDp[0][nums.length - 1];
    }
}