import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] x = new long[N], y = new long[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        for(int p1 = 0 ; p1 < N - 2 ; p1++){
            for(int p2 = p1 + 1 ; p2 < N - 1 ; p2++){
                for(int p3 = p2 + 1 ; p3 < N ; p3++){
                    long[] dist = new long[3];
                    dist[0] = (x[p1] - x[p2]) * (x[p1] - x[p2]) + (y[p1] - y[p2]) * (y[p1] - y[p2]);
                    dist[1] = (x[p2] - x[p3]) * (x[p2] - x[p3]) + (y[p2] - y[p3]) * (y[p2] - y[p3]);
                    dist[2] = (x[p3] - x[p1]) * (x[p3] - x[p1]) + (y[p3] - y[p1]) * (y[p3] - y[p1]);
                    if(dist[0] == dist[1] + dist[2] || dist[1] == dist[0] + dist[2] || dist[2] == dist[0] + dist[1]) count++;
                }
            }
        }
        System.out.println(count);
    }
}
