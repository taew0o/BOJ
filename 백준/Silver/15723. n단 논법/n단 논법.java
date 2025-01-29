import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int LEN = 'z' - 'a' + 1;
        boolean[][] graph = new boolean[LEN][LEN];

        int N = Integer.parseInt(br.readLine());
        while (N --> 0){
            String str = br.readLine();
            graph[str.charAt(0) - 'a'][str.charAt(5) - 'a'] = true;
        }

        for(int k = 0 ; k < LEN ; k++){
            for(int i = 0 ; i < LEN ; i++){
                for(int j = 0 ; j < LEN ; j++){
                    if(i != j && !graph[i][j] && graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        while (M --> 0){
            String str = br.readLine();
            sb.append(graph[str.charAt(0) - 'a'][str.charAt(5) - 'a'] ? "T" : "F").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
