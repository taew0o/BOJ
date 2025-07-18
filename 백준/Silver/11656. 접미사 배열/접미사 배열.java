import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String[] suffixes = new String[S.length()];
        for(int i = 0 ; i < S.length() ; i++){
            suffixes[i] = S.substring(i);
        }
        Arrays.sort(suffixes);
        for(String suffix : suffixes){
            sb.append(suffix).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
