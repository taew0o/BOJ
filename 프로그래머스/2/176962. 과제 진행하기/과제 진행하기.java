import java.util.*;
class Solution {
    public static class Assignment implements Comparable<Assignment> {
        String name;
        int start, playtime;
        public Assignment(String[] plan){
            this.name = plan[0];
            String[] startInfo = plan[1].split(":");
            this.start = Integer.parseInt(startInfo[0]) * 60 + Integer.parseInt(startInfo[1]);
            this.playtime = Integer.parseInt(plan[2]);
        }
        @Override
        public int compareTo(Assignment o1) {
            return this.start - o1.start;
        }
    }
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        int order = 0;
        Assignment[] works = new Assignment[N];
        for(int i = 0 ; i < N ; i++){
            works[i] = new Assignment(plans[i]);
        }
        Arrays.sort(works);
        Stack<Assignment> s = new Stack<>();
        for(int i = 0 ; i < N - 1 ; i++){
            if(works[i].start + works[i].playtime <= works[i + 1].start){
                answer[order++] = works[i].name;
                int remain = works[i + 1].start - works[i].start - works[i].playtime;
                while(remain > 0 && !s.isEmpty()){
                    if(s.peek().playtime <= remain){
                        Assignment now = s.pop();
                        answer[order++] = now.name;
                        remain -= now.playtime;
                    } else{
                        s.peek().playtime -= remain;
                        remain = 0;
                    }
                }
            } else{
                works[i].playtime -= works[i + 1].start - works[i].start;
                s.push(works[i]);
            }
        }
        answer[order++] = works[N - 1].name;
        while(!s.isEmpty()){
            answer[order ++] = s.pop().name;
        }
        return answer;
    }
}