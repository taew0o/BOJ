import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());

        int count = 0;
        while (N --> 0){
            st = new StringTokenizer(br.readLine());
            int[] x = new int[4], y = new int[4];
            double centerX = 0, centerY = 0;
            for(int i = 0 ; i < 4 ; i++){
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                centerX += x[i]; centerY += y[i];
            }
            centerX /= 4; centerY /= 4;
            int width = Math.abs(x[2] - x[0]), height = Math.abs(y[2] - y[0]);
            double minDist = Math.sqrt(centerX * centerX + centerY * centerY) - Math.sqrt(width * width + height * height) / 2;
            if(minDist <= R) count++;
        }
        System.out.println(count);
    }
}
