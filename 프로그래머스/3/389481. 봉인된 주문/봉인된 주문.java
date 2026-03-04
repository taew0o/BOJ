import java.util.*;
class Solution {
    public String orderToSpell(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--; // 0-indexed로 맞추기 위해 1 감소
            sb.append((char) ('a' + (n % 26)));
            n /= 26;
        }
        return sb.reverse().toString();
    }
    public static long spellToOrder(String spell){
        long result = 0;
        for(int i = 0 ; i < spell.length() ; i++){
            result *= 26;
            result += spell.charAt(i) - 'a' + 1;
        }
        return result;
    }
    public String solution(long n, String[] bans) {
        String answer = "";
        HashSet<Long> bannedSpells = new HashSet<>();
        long count = 0;
        for(String spell : bans){
            long order = spellToOrder(spell);
            bannedSpells.add(order);
            if(n >= order){
                count++;
            }
        }
        for(long i = 0 ; i < count ; i++){
            n++;
            while(bannedSpells.contains(n)){
                n++;
            }
        }
        return orderToSpell(n);
    }
}