import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = str.charAt(j) == 'Y';
            }
        }

        int[] friends = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                //i와 j가 2-친구이기 위해서는 i <-> k가 친구이고 k <-> j가 친구인 k가 존재해야 한다.
                if(i != j) {
                    if(map[i][j]){
                        friends[i]++;
                        continue;
                    }
                    for (int k = 0; k < N; k++) {
                        if (map[i][k] && map[k][j]) {
                            friends[i]++;
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, friends[i]);
        }
        System.out.println(max);
    }
}
