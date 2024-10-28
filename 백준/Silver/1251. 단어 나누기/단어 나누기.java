import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String divide(String str, int first, int second){
        String result = "";
        for(int i = first - 1;  i >= 0 ; i--){
            result += str.charAt(i);
        }
        for(int i = second - 1 ; i >= first ; i--){
            result += str.charAt(i);
        }
        for(int i = str.length() - 1; i >= second ; i--){
            result += str.charAt(i);
        }
        return result;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String result = "~";//알파벳 소문자보다 큰 값으로 하기 위함
        String str = bufferedReader.readLine();
        for(int i = 1 ; i < str.length() - 1; i++){
            for(int j = i + 1 ; j < str.length() ; j++){
                String divideStr = divide(str,i,j);
                if(divideStr.compareTo(result) < 0){
                    result = divideStr;
                }
            }
        }
        System.out.println(result);
    }
}