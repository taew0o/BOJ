import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(N == 1 ? 1 : 2 * N - 2).append('\n');
        for(int i = 1 ; i <= N ; i++){
            sb.append(1).append(" ").append(i).append('\n');
        }
        for(int i = 2 ; i < N ; i++){
            sb.append(N).append(" ").append(i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
