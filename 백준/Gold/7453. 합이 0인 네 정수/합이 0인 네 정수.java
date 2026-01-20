import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arrs = new int[4][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arrs[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] left = new int[N * N], right =  new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                left[i * N + j] = arrs[0][i] + arrs[1][j];
                right[i * N + j] = arrs[2][i] + arrs[3][j];
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int leftIndex = 0, rightIndex = N * N - 1;
        long count = 0;
        while (leftIndex < N * N && rightIndex >= 0) {
            int sum = left[leftIndex] + right[rightIndex];
            if(sum < 0){
                leftIndex++;
            } else if(sum > 0){
                rightIndex--;
            } else{
                int leftTemp = left[leftIndex], rightTemp = right[rightIndex];
                int leftCount = 0, rightCount = 0;
                while(leftIndex < N * N && left[leftIndex] == leftTemp){
                    leftCount++;
                    leftIndex++;
                }
                while(rightIndex >= 0 && right[rightIndex] == rightTemp){
                    rightCount++;
                    rightIndex--;
                }
                count += (long) leftCount * rightCount;
            }
        }
        System.out.println(count);
    }
}
