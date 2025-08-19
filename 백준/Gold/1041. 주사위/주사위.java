import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (N == 1){
            System.out.println(Arrays.stream(dice).sum() - Arrays.stream(dice).max().getAsInt());
            return;
        }

        long minThree = Long.MAX_VALUE, minTwo = Long.MAX_VALUE, minOne = Long.MAX_VALUE;
        for(int i = 0 ; i < 6 ; i++){
            minOne = Math.min(minOne, dice[i]);
            for(int j = 0 ; j < 6 ; j++){
                if (i != j && i + j != 5){
                    minTwo = Math.min(minTwo, dice[i] + dice[j]);
                    for(int k = 0 ; k < 6 ; k++){
                        if (k != i && k != j && i + k != 5 && j + k != 5){
                            minThree = Math.min(minThree, dice[i] + dice[j] + dice[k]);
                        }
                    }
                }
            }
        }

        long max = 4L * minThree + 4L * minTwo + 8L * (N - 2) * minTwo + 4L * (N - 1) * (N - 2) * minOne + (long) (N - 2) * (N - 2) * minOne;
        System.out.println(max);
    }
}
