import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumA = new int[N];
        sumA[0] = A[0];
        for(int i = 1 ; i < N ; i++){
            sumA[i] = sumA[i - 1] + A[i];
        }
        HashMap<Integer, Integer> countNumA = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            countNumA.put(sumA[i], countNumA.getOrDefault(sumA[i], 0) + 1);
            for(int j = 0 ; j < i ; j++){
                countNumA.put(sumA[i] - sumA[j], countNumA.getOrDefault(sumA[i] - sumA[j], 0) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumB = new int[M];
        sumB[0] = B[0];
        for(int i = 1 ; i < M ; i++){
            sumB[i] = sumB[i - 1] + B[i];
        }
        HashMap<Integer, Integer> countNumB = new HashMap<>();
        for(int i = 0 ; i < M ; i++){
            countNumB.put(sumB[i], countNumB.getOrDefault(sumB[i], 0) + 1);
            for(int j = 0 ; j < i ; j++){
                countNumB.put(sumB[i] - sumB[j], countNumB.getOrDefault(sumB[i] - sumB[j], 0) + 1);
            }
        }

        long result = 0;
        for (int num : countNumA.keySet()){
            if (countNumB.containsKey(T - num)){
                result += (long) countNumA.get(num) * countNumB.get(T - num);
            }
        }
        System.out.println(result);
    }
}
