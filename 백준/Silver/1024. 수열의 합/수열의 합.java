import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static int N;
    static int L;
    static int[] array;
    public static long isAvailable(int length){
        long start = N / length - (length - 1) / 2;
        if(start < 0){
            return -1;
        }
        if(N == (start * 2 + length - 1) * length / 2){
            return start;
        }
        return -1;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        L = Integer.parseInt(str.split(" ")[1]);
        array = new int[100];
        for(int i = L ; i <= 100 ; i++){
            long start = isAvailable(i);
            if(start != -1){
                for(int j = 0 ; j < i ; j++){
                    System.out.print(start + j + " ");
                }
                System.out.println();
                return;
            }
        }
        System.out.println(-1);
    }
}
