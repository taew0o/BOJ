import java.io.*;

public class Main {
    static int K = 0;
    static StringBuilder sb = new StringBuilder();
    public static void Hanoi(int num , int from , int to){
        K++;
        if(num == 1){
            sb.append(from).append(" ").append(to).append('\n');
            return;
        }
        int temp = from + to == 3 ? 3 : from + to == 4 ? 2 : 1;
        Hanoi(num - 1, from , temp);
        sb.append(from).append(" ").append(to).append('\n');
        Hanoi(num - 1, temp, to);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Hanoi(N, 1, 3);

        bw.write(K + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
