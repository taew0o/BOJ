import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static long gcd(long a, long b){
        while (b != 0){
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[][] juice = new int[N][2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            juice[i][0] = Integer.parseInt(st.nextToken());
            juice[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(juice, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(((double) o2[1] / o2[0]), ((double) o1[1] / o1[0]));
            }
        });

        long count = 0;
        long a = 0 , b = 1;
        for(int i = 0 ; i < N ; i++){
            if(count + juice[i][0] < M){
                count += juice[i][0];
                a += juice[i][1];
            }
            else{
                b = juice[i][0];
                a = (a * b) + (juice[i][1] * (M - count));
                long gcd = gcd(b, a);
                a /= gcd;
                b /= gcd;
                break;
            }
        }
        System.out.println(a + "/" + b);
    }
}
