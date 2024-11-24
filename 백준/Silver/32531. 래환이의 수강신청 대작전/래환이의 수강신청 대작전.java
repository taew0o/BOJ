import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] student = new int[M + 1];

        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = 1 ; j <= M ; j++){
                student[j] = student[j] << 1;
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (s --> 0){
                student[Integer.parseInt(st.nextToken())]++;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : student){
            if (n != 0) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        if(map.isEmpty()){
            System.out.println(0);
        }
        else{
            int count = 1;
            for(int value : map.values()){
                count *= value == 1 ? 2 : value;
            }
            System.out.println(count);
        }
    }
}
