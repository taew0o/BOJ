import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(N).append(" ");
        for(int i = 1 ; i <= (N - 1) / 2 ; i++){
            sb.append(i).append(" ").append(N - i).append(" ");
        }
        if(N % 2 == 0){
            sb.append(N / 2);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
