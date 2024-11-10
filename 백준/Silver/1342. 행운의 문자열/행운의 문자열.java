import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int len;
    static int[] countChar, order;
    static int count = 0;
    static void dfs(int index){
        if(index == len) {
            count++;
            return;
        }
        for(int i = 0 ; i <= 'z' - 'a' ; i++){
            if(countChar[i] > 0 && order[index - 1] != i){
                countChar[i]--;
                order[index] = i;
                dfs(index + 1);
                countChar[i]++;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        len = str.length();
        countChar = new int['z' - 'a' + 1]; order = new int[len];

        for(int i = 0 ; i < len ; i++){
            countChar[str.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i <= 'z' - 'a' ; i++){
            if(countChar[i] > 0){
                countChar[i]--;
                order[0] = i;
                dfs(1);
                countChar[i]++;
            }
        }

        System.out.println(count);
    }
}
