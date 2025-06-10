class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health, duration = 0;
        int time = 1 , index_attack = 0;
        while (index_attack != attacks.length){
            if(time == attacks[index_attack][0]){
                hp -= attacks[index_attack][1];
                if(hp <= 0) return -1;
                duration = 0;
                index_attack++;
            }
            else {
                hp = Math.min(health, hp + bandage[1]);
                if (++duration == bandage[0]) {
                    hp = Math.min(health, hp + bandage[2]);
                    duration = 0;
                }
            }
            time++;
        }

        return hp;
    }
}