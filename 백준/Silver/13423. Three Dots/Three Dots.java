import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(pos);

            int count = 0;
            for(int mid = 1 ; mid < N - 1 ; mid++){
                int l = mid - 1, r = mid + 1;
                while (l >= 0 && r < N){
                    int dl = pos[mid] - pos[l];
                    int dr = pos[r] - pos[mid];
                    if (dl == dr){
                        count++;
                        l--;
                        r++;
                    }
                    else if (dl < dr){
                        l--;
                    }
                    else{
                        r++;
                    }
                }
            }

            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
