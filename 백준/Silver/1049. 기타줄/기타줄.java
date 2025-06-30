import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int minPriceForSix = Integer.MAX_VALUE , minPriceForOne = Integer.MAX_VALUE;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            minPriceForSix = Math.min(minPriceForSix, Integer.parseInt(st.nextToken()));
            minPriceForOne = Math.min(minPriceForOne, Integer.parseInt(st.nextToken()));
        }

        int six = N / 6, one = N % 6;
        System.out.println(Math.min(minPriceForSix, minPriceForOne * 6) * six
                + Math.min(minPriceForSix , minPriceForOne * one));
    }
}
