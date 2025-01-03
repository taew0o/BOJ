import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000 + 1];
        int num = 1;
        int count = 0;
        for(int i = 1 ; i <= 1000 ; i++){
            arr[i] = num;
            count++;
            if(count == num){
                num++;
                count = 0;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = a ; i <= b ; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
