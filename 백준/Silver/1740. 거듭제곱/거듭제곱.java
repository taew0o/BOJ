import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long result = 0;
        long digit = 1;
        while (N != 0){
            result += (N & 1) * digit;
            digit *= 3;
            N >>= 1;
        }

        System.out.println(result);
    }
}
