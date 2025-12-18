import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(info, (o1, o2) -> o1[0] - o2[0]);
        int time = 0;
        for(int i = 0; i < N; i++){
            if(info[i][0] >= time){
                time = info[i][0] + info[i][1];
            }
            else{
                time += info[i][1];
            }
        }
        System.out.println(time);
    }
}
