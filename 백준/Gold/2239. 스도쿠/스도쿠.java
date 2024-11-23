import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] row, col, block;
    static boolean dfs(int r, int c){
        if(c == 9){
            r++;
            c = 0;
        }
        if(r == 9) return true;
        if(arr[r][c] == 0){
            for(int i = 1 ; i <= 9 ; i++){
                if(!row[r][i] && !col[c][i] && !block[(r / 3) * 3 + c / 3][i]){
                    arr[r][c] = i;
                    row[r][i] = true; col[c][i] = true; block[(r / 3) * 3 + c / 3][i] = true;
                    if(dfs(r, c + 1)) return true;
                    arr[r][c] = 0;
                    row[r][i] = false; col[c][i] = false; block[(r / 3) * 3 + c / 3][i] = false;
                }
            }
        }
        else{
            return dfs(r , c + 1);
        }
        return false;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = new int[9][9];
        //각각 해당 열, 해당 행, 해당 block에 숫자 n이 현재 포함되어 있는지
        row = new boolean[9][10]; col = new boolean[9][10]; block = new boolean[9][10];
        for(int i = 0 ; i < 9 ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < 9 ; j++){
                arr[i][j] = str.charAt(j) - '0';
                if(arr[i][j] != 0){
                    int n = arr[i][j];
                    row[i][n] = true; col[j][n] = true; block[(i / 3) * 3 + j / 3][n] = true;
                }
            }
        }

        dfs(0,0);
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
