import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lResult = -1, rResult = -1, sum = Integer.MAX_VALUE;
        int lPointer = 0, rPointer = N - 1;

        while (lPointer < rPointer){
            int temp = arr[rPointer] + arr[lPointer];
            if(Math.abs(temp) < sum){
                sum = Math.abs(temp);
                lResult = arr[lPointer]; rResult = arr[rPointer];
            }
            if(sum == 0) break;
            if(temp < 0) lPointer++;
            else rPointer--;
        }
        System.out.println(lResult + " " + rResult);
    }
}
