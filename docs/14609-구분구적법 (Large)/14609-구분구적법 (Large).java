import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] C;
    static int a, b;
    static double target = 0 , delta;
    public static double function(double x){
        double result = 0;
        for(int i = 0 ; i <= K ; i++){
            result += C[i] * Math.pow(x, i);
        }
        return  result;
    }
    public static double approximate(double e){
        double result = 0;
        for(int k = 0 ; k < N ; k++){
            result += function(a + k * delta + e) * delta;
        }
        return result;
    }
    public static void binarySearch(double left, double right){
        while (left < right){
            double mid = (left + right) / 2;
            double value = approximate(mid);
            if(Math.abs(target - value) <= 0.0001){
                System.out.println(mid);
                return;
            }
            else if(target < value){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        System.out.println(-1);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        C = new int[K + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = K ; i >= 0 ; i--){
            C[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        target = 0; //실제 적분 결과값
        for(int i = 0 ; i <= K ; i++){
            target += C[i] * (Math.pow(b, i + 1) - Math.pow(a, i + 1)) / (i + 1);
        }
        delta = (double) (b - a) / N;
        binarySearch(0d, delta);
    }
}
