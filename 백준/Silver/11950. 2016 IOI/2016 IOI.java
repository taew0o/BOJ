import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                char c = str.charAt(j);
                if(c == 'W') arr[i][0]++;
                else if(c == 'B') arr[i][1]++;
                else arr[i][2]++;
            }
        }

        int min = 10000;
        for(int i = 1 ; i < N - 1 ; i++){
            for(int j = i + 1 ; j < N ; j++){
                int count = 0;
                //White
                for(int w = 0 ; w < i ; w++){
                    count += M - arr[w][0];
                }
                //Blue
                for(int b = i ; b < j ; b++){
                    count += M - arr[b][1];
                }
                //RED
                for(int r = j ; r < N ; r++){
                    count += M - arr[r][2];
                }
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }
}
