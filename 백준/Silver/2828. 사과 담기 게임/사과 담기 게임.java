import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()) - 1, J = Integer.parseInt(br.readLine());

        int basket = 1;
        int dist = 0;
        while (J --> 0){
            int apple = Integer.parseInt(br.readLine());
            if(apple < basket){
                dist += basket - apple;
                basket = apple;
            }
            else if(basket + M < apple){
                dist += apple - (basket + M);
                basket = apple - M;
            }
        }
        System.out.println(dist);
    }
}
