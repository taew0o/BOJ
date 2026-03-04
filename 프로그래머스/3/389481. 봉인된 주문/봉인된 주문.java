import java.util.*;
class Solution {
    public static String orderToSpell(long order){
        String result = "";
        while(order != 0){
            order --;
            result = (char)((order % 26) + 'a') + result;
            order /= 26;
        }
        return result;
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
        System.out.println(count);
        for(long i = 0 ; i < count ; i++){
            n++;
            while(bannedSpells.contains(n)){
                n++;
            }
        }
        return orderToSpell(n);
    }
}