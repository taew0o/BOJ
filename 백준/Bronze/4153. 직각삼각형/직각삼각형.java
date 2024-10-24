import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            if(a == 0) return;
            if(a > c){
                long tmp = c;
                c = a; a = tmp;
            }
            if(b > c){
                long tmp = c;
                c = b; b = tmp;
            }
            System.out.println(((c * c) == (a * a) + (b * b)) ? "right" : "wrong");
        }
    }
}
