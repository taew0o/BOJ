import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        final int MAX = 1_000_000;
        int[] cards = new int[N], result = new int[N];
        int[] cardIndex = new int[MAX + 1];
        Arrays.fill(cardIndex, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            cardIndex[cards[i]] = i;
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 2 ; cards[i] * j <= MAX ; j++){
                if(cardIndex[cards[i] * j] != -1){
                    result[i]++;
                    result[cardIndex[cards[i] * j]]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            sb.append(result[i] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
