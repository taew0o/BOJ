import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,target,sum;
    static int[] array;
    static int count = 0;
    public static void dfs(int i,int c,int sumNow){
        if(i == n){
            if(sumNow == target && c > 0){
                count++;
            }
        }
        else{
            dfs(i + 1, c + 1, sumNow + array[i]);//선택 o
            dfs(i + 1, c, sumNow);//선택 x
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        target = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        sum = 0;
        for(int i = 0 ; i < n ;i++){
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum += array[i];
        }
        Arrays.sort(array);
        dfs(0,0, 0);
        System.out.println(count);
    }
}
