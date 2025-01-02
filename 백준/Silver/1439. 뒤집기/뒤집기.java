import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char now = str.charAt(0);
        int count = 0;

        for(int i = 1 ; i < str.length() ; i++){
            if(str.charAt(i) != now){
                count++;
                now = str.charAt(i);
            }
        }

        System.out.println((count + 1) / 2);
    }
}
