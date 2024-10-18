import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = -1;//0이 결과에 포함될 것이기 때문에 -1로 시작
        for(int i = 0 ; i <= (N / 100) + 1 ; i++){
            for(int j = 0 ; j <= 9 ; j++){
                for(int k = 0 ; k <= 9 ; k++){
                    if(i * 100 + j * 10 + k > N) break;
                    if(i == 0) count++;
                    else count += ((i - j) == (j - k)) ? 1 : 0;
                }
            }
        }
        System.out.println(count);
    }
}
