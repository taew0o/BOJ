import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int size = 1;
        int digit = 0;
        while (K > size){
            size*= 2;
            digit++;
        }

        int count = digit;
        while (K > 0){
            if((K & 1) > 0){
                break;
            }
            K >>= 1;
            count--;
        }
        System.out.println(size + " " + count);
    }
}
