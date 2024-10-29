import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double a,d,k;
    public static double calAvgTime(double d){
        if(d >= 1) return a;
        return a * d + (1 - d) * (a + calAvgTime(d * (1 + k)));
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Double.parseDouble(st.nextToken()); d = Double.parseDouble(st.nextToken()) / 100;
        k = Double.parseDouble(st.nextToken()) / 100;
        System.out.println(calAvgTime(d));
    }
}
