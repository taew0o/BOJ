import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] data = new int[n][n];
        int r = n/2;
        int c = n/2;
        data[r][c] = 1;
        int num_line = n;
        for(int i = 0;  i < n/2; i ++){
            int start = num_line * num_line; r = i ; c = i;
            for(int j = 0 ; j < num_line - 1; j++){
                data[r][c] = start;
                start--;
                r++;
            }
            for(int j = 0 ; j < num_line - 1; j++){
                data[r][c] = start;
                start--;
                c++;
            }
            for(int j = 0 ; j < num_line - 1 ; j++){
                data[r][c] = start;
                start--;
                r--;
            }
            for(int j = 0 ; j < num_line - 1 ; j++){
                data[r][c] = start;
                start--;
                c--;
            }
            num_line -= 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(data[i][j] == target){
                    r = i + 1; c = j + 1;
                }
                stringBuilder.append(data[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(r + " " + c);
        System.out.println(stringBuilder.toString());
    }
}
