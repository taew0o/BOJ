import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());
        while (N --> 0){
            String word = br.readLine();
            HashSet<Character> set = new HashSet<>();
            boolean ok = true;
            char prev = word.charAt(0);
            set.add(prev);
            for(int i = 1 ; i < word.length() ; i++){
                char next = word.charAt(i);
                if(prev != next){
                    if(set.contains(next)){
                        ok = false;
                        break;
                    }else{
                        set.add(next);
                        prev = next;
                    }
                }
            }
            if(ok) count++;
        }
        System.out.println(count);
    }
}
