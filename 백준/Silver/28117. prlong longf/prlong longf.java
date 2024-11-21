import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fibbo = new int[20 + 1];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //피보나치 수열 초기화
        fibbo[0] = 1;
        fibbo[1] = 1;
        for(int i = 2 ; i <= 20 ; i++){
            fibbo[i] = fibbo[i - 2] + fibbo[i - 1];
        }


        int N = Integer.parseInt(br.readLine());
        String str = br.readLine().replaceAll("long", "@");

        int len = str.length();
        int result = 1;
        int rowLong = 0;
        for(int i = 0 ; i < len ; i++){
            if(str.charAt(i) == '@'){
                rowLong++;
            }
            else{
                result *= fibbo[rowLong];
                rowLong = 0;
            }
        }
        result *= fibbo[rowLong];
        System.out.println(result);
    }
}
