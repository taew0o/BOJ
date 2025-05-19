import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> ryanPos = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(st.nextToken().equals("1")){
                ryanPos.add(i);
            }
        }

        if(ryanPos.size() < K){
            System.out.println(-1);
            return;
        }

        int result = 1_000_000;
        for(int i = 0 ; i <= ryanPos.size() - K ; i++){
            result = Math.min(result , ryanPos.get(i + K - 1) - ryanPos.get(i) + 1);
        }

        System.out.println(result);
    }
}
