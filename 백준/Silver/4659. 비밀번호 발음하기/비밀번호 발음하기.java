import java.io.*;
import java.util.HashSet;

public class Main{
    public static boolean isAcceptablePassword(String password){
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        boolean isVowelExist = false;
        char prev1, prev2;

        prev1 = password.charAt(0);
        isVowelExist = vowels.contains(prev1);
        if (password.length() == 1) return isVowelExist;

        prev2 = password.charAt(1);
        isVowelExist = isVowelExist || vowels.contains(prev2);
        if (password.length() == 2){
            return isVowelExist && !(prev1 == prev2 && prev1 != 'e' && prev1 != 'o');
        }

        if (prev1 == prev2 && prev1 != 'e' && prev1 != 'o'){
            return false;
        }

        for(int i = 2 ; i < password.length() ; i++){
            char c = password.charAt(i);
            if (!isVowelExist && vowels.contains(c)) isVowelExist = true;
            if (prev2 == c && prev2 != 'e' && prev2 != 'o'){
                return false;
            }
            if ((vowels.contains(prev1) && vowels.contains(prev2) && vowels.contains(c)) || (!vowels.contains(prev1) && !vowels.contains(prev2) && !vowels.contains(c))){
                return false;
            }
            prev1 = prev2;
            prev2 = c;
        }
        return isVowelExist;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = br.readLine();
            if (str.equals("end")) break;
            sb.append(String.format("<%s> is%s acceptable.", str, isAcceptablePassword(str) ? "" : " not")).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
