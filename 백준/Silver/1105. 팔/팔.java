import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken(), right = st.nextToken();
        if(left.length() != right.length()){
            System.out.println(0);
            return;
        }

        int count = 0;
        for(int i = 0 ; i < left.length() ; i++){
            if(left.charAt(i) == right.charAt(i)){
                if(left.charAt(i) == '8') count++;
            }
            else break;
        }
        System.out.println(count);
    }
}
