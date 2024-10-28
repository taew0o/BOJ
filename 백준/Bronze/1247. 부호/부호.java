import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 3 ; i++){
            int N = Integer.parseInt(br.readLine());
            BigInteger num = new BigInteger("0");
            while (N --> 0){
                num = num.add(new BigInteger(br.readLine()));
            }
            int result = num.compareTo(new BigInteger("0"));
            if(result == 0){
                sb.append(0).append('\n');
            }
            else if(result < 0){
                sb.append('-').append('\n');
            }
            else{
                sb.append('+').append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
