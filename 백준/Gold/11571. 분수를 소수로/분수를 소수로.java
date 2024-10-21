import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b){
        while (b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public static String fractionToDemical(int top, int bottom){
        if(top % bottom == 0){
            return (top / bottom) + ".(0)";
        }
        int gcd = gcd(top, bottom);
        top /= gcd; bottom /= gcd;
        String result = "";
        result += (top / bottom) + ".";
        int[] arrMod = new int[bottom]; //각 나머지가 언제 처음 등장하는지
        arrMod[top % bottom] = result.length();
        top = (top % bottom) * 10;
        int index = result.length() + 1;
        while (true){
            int q = (top / bottom), r = (top % bottom);
            if(r == 0){
                result += q + "(0)";
                return result;
            }
            else if(arrMod[r] != 0){
                result = result.substring(0, arrMod[r]) + "(" + result.substring(arrMod[r]) + q + ")";
                return result;
            }
            result += q;
            arrMod[r] = index++;
            top = r * 10;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int top = Integer.parseInt(st.nextToken()), bottom = Integer.parseInt(st.nextToken());
            sb.append(fractionToDemical(top, bottom)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
