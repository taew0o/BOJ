import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;
        Set<Integer> myHand = new HashSet<>();
        Set<Integer> candidateHand = new HashSet<>();
        
        int i = 0;
        for(; i < n / 3 ; i++){
            myHand.add(cards[i]);
        }
        
        int round = 1;
        while(i < n){
            candidateHand.add(cards[i++]);
            candidateHand.add(cards[i++]);
            boolean canGoNext = false;
            if(check(myHand, myHand, target)){
                canGoNext = true;
            } else if(coin >= 1 && check(myHand, candidateHand, target)){
                coin--;
                canGoNext = true;
            } else if(coin >= 2 && check(candidateHand, candidateHand, target)){
                coin -= 2;
                canGoNext = true;
            }
            if(!canGoNext) break;
            round++;
        }
        return round;
    }
    public static boolean check(Set<Integer> set1, Set<Integer> set2, int target){
        for(int num : set1){
            int needed = target - num;
            if(set2.contains(needed)){
                set1.remove(num);
                set2.remove(needed);
                return true;
            }
        }
        return false;
    }
}