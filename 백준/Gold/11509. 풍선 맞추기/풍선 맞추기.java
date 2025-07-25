import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] balloons = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrows = new int[1_000_000 + 1];
        int count = 0;
        for(int balloon : balloons){
            if (arrows[balloon] == 0){
                count++;
            }
            else{
                arrows[balloon]--;
            }
            arrows[balloon - 1]++;
        }
        System.out.println(count);
    }
}
