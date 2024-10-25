import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            int[][] grade = new int[N][2];
            for(int i = 0 ; i < N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                grade[i][0] = Integer.parseInt(st.nextToken());
                grade[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(grade, (o1, o2) -> o1[0] - o2[0]);
            int min = grade[0][1];
            int result = N;
            for(int i = 1 ; i < N ; i++){
                if(grade[i][1] < min) min = grade[i][1];
                else result--;
            }
            sb.append(result).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
