import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        int[] points = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);
        int result = 0;
        int now = 0;
        for(int point : points){
            if(point > now){
                result ++;
                now = point + L - 1;
            }
        }
        System.out.println(result);
    }
}
