import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0 , count = 1;
        for(int i = 0 ; i < X ; i++){
            max += arr[i];
        }

        int now = max;
        int l = 0;
        for(int r = X ; r < N ; r++){
            now -= arr[l]; now += arr[r];
            l++;
            if(now > max){
                max = now;
                count = 1;
            }
            else if(now == max){
                count++;
            }
        }
        if(max == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
