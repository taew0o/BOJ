import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            indexList.add(i);
        }

        int[] result = new int[N];
        for(int i = 0 ; i < N ; i++){
            result[indexList.remove(arr[i])] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : result){
            sb.append(n).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
