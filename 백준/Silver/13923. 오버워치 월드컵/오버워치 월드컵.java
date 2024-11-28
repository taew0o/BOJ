import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null){
            int N = Integer.parseInt(str);
            char[][] row = new char[N][N];
            char[][] col = new char[N][N];
            for(int i = 0 ; i < N ; i++){
                row[i] = br.readLine().toCharArray();
                for(int j = 0 ; j < N ; j++){
                    col[j][i] = row[i][j];
                }
            }

            for(int i = 0 ; i < N ; i++){
                Arrays.sort(row[i]);
                Arrays.sort(col[i]);
            }

            int r = -1 , c = -1;

            for(int i = 0 ; i < N - 1 ; i++){
                if(!Arrays.equals(row[i], row[i + 1])){
                    if(i == 0){
                        r = Arrays.equals(row[i + 1], row[i + 2]) ? 0 : 1;
                    } else{
                        r = i + 1;
                    }
                    for(int j = 0 ; j < N - 1 ; j++){
                        if(!Arrays.equals(col[j], col[j + 1])){
                            if(j == 0){
                                c = Arrays.equals(col[j + 1], col[j + 2]) ? 0 : 1;
                            }
                            else{
                                c = j + 1;
                            }
                            sb.append(r + 1).append(" ").append(c + 1).append(" ");
                            break;
                        }
                    }

                    int right = r == 0 ? 1 : 0;
                    for(int j = 0 ; j < N ; j++){
                        char target = row[right][j];
                        boolean flag = false;
                        for(int k = 0 ; k < N ; k++){
                            if(row[r][k] == target){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            sb.append(target).append('\n');
                            break;
                        }
                    }
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
