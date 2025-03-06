import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPalindrome(String str){
        int len = str.length();
        for(int i = 0 ; i < len / 2 ; i++){
            if(str.charAt(i) != str.charAt(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isAraraka(String str){
        int len = str.length();
        if(len == 1) return true;
        return isPalindrome(str) && isAraraka(str.substring(0,len / 2)) && isAraraka(str.substring(len % 2 == 0 ? len / 2 : len / 2 + 1));
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isAraraka(br.readLine()) ? "AKARAKA" : "IPSELENTI");
    }
}
