import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> list;
    static int[] arr,order;
    static int binarySearch(int target){
        int left = 0, right = list.size();
        while(left < right){
            int mid = left + (right - left)/2;
            if(target <= list.get(mid)){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        list.add(arr[0]);
        order = new int[N];
        order[0] = 0;
        for(int i = 1 ; i < N ; i++){
            int next = arr[i];
            if(list.get(list.size()-1) < next){
                list.add(next);
                order[i] = list.size() - 1;
            } else{
                int index = binarySearch(next);
                list.set(index, next);
                order[i] = index;
            }
        }
        int target = list.size() - 1;
        int[] result = new int[list.size()];
        for(int i = N - 1 ; i >= 0 ; i--){
            if(order[i] == target){
                result[target] = arr[i];
                target--;
            }
        }
        sb.append(list.size()).append('\n');
        for(int i = 0 ; i < result.length ; i++){
            sb.append(result[i]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
