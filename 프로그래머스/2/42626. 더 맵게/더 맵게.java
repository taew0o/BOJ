import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int food : scoville){
            queue.offer(food);
        }
        int answer = 0;
        while(queue.size() > 1){
            if(queue.peek() >= K){
                return answer;
            }
            queue.offer(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return queue.peek() >= K ? answer : -1;
    }
}