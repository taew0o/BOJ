import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static boolean isSubmarineSound(String sound){
        //(100~1~|01)~
        String regex = "(100+1+|01)+";
        return Pattern.matches(regex, sound);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isSubmarineSound(br.readLine()) ? "SUBMARINE" : "NOISE");
    }
}
