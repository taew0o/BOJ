import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[] cards, cardsIndex;
    static int[] oppOrder;
    static int[] nearlestMaxIndex, parent;
    static int find(int x){
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            parent[pa] = pb;
        } else if(pb < pa){
            parent[pb] = pa;
        }
    }
    //UPPER BOUND
    public static int binarySearch(int target){
        int left = 0, right = M - 1;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(cards[mid] > target){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cards = new int[M + 1];
        parent = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        cards[M] = Integer.MAX_VALUE;
        Arrays.sort(cards);

        cardsIndex = new int[N + 1];
        for(int i = 0 ; i <= M ; i++){
            parent[i] = i;
        }

        oppOrder = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            oppOrder[i] = Integer.parseInt(st.nextToken());
        }

        nearlestMaxIndex = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            nearlestMaxIndex[i] = binarySearch(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int opp : oppOrder){
            int next = find(nearlestMaxIndex[opp]);
            sb.append(cards[next]).append('\n');
            union(next, next + 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
