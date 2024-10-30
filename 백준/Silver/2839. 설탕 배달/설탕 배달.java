import java.util.Scanner;
public class Main {
    public static int deliver(int N){
        int[] array = new int[N + 1];
        if (N == 3 || N == 5) {
            return 1;
        }
        else if(N == 4){
            return -1;
        }
        array[1] = -1;
        array[2] = -1;
        array[3] = 1;
        array[4] = -1;
        array[5] = 1;
        for(int i = 6 ; i <= N ; i++){
            if(array[i - 5] != -1 && array[i - 3] != -1){
                array[i] = Math.min(array[i - 5], array[i - 3]) + 1;
            }
            else if(array[i - 5] == -1 && array[i - 3] != -1){
                array[i] = array[i - 3] + 1;
            }
            else if(array[i - 5] != -1 && array[i - 3] == -1){
                array[i] = array[i - 5] + 1;
            }
            else{
                array[i] = -1;
            }
        }
        return array[N];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(deliver(N));
    }
}
