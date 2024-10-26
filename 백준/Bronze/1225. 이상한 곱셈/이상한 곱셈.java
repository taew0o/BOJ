import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str,numStr1,numStr2;
        long num1,num2;
        str = bufferedReader.readLine();
        numStr1 = str.split(" ")[0];
        numStr2 = str.split(" ")[1];
        if(numStr1.equals("0") || numStr2.equals("0")) {
            System.out.println(0);
            return;
        }
        num1 = 0;
        for(int i = 0 ; i < numStr1.length() ; i++){
            num1 += numStr1.charAt(i) - '0';
        }
        num2 = 0;
        for(int j = 0 ; j < numStr2.length() ; j++){
             num2 += numStr2.charAt(j) - '0';
        }
        System.out.println(num1 * num2);

    }
}
