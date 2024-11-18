import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N <= 2){
            System.out.println(0);
            return;
        }

        long sum = 0;
        boolean isChanged = true;
        while (isChanged){
            isChanged = false;
            for(int i = 1 ; i < N - 1 ; i++){
                int side = arr[i - 1] + arr[i + 1];
                if(arr[i] * 2 > side){
                    sum += arr[i] - side / 2;
                    arr[i] = side / 2;
                    isChanged = true;
                }
            }
        }

        System.out.println(sum);
    }
}
