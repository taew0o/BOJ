import java.util.*;
class Solution {
    public boolean isOnTime(int hope, int real){
        int real_hour = real / 100, real_minute = real % 100;
        if(real_minute >= 10){
            real_minute -= 10;
        } else{
            real_hour--;
            real_minute += 50;
        }
        return real_hour * 100 + real_minute <= hope;
    }
    public boolean isWeekend(int startday, int now){
        int day = ((startday - 1) + now) % 7;
        return day == 5 || day == 6;
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int len = schedules.length;
        int count = len;
        for(int i = 0 ; i < len ; i++){
            int[] timelog = timelogs[i];
            boolean flag = true;
            for(int now = 0 ; now < 7 ; now++){
                if(!isWeekend(startday, now) && !isOnTime(schedules[i], timelog[now])){
                    flag = false;
                    break;
                }
            }
            if(!flag) count--;
        }
        return count;
    }
}