import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    public static int binarySearch(int target){
        int left = 0, right = list.size();
        while (left < right){
            int mid = (left + right) / 2;
            if(target > list.get(mid)){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list.add(arr[0]);
        for(int i = 1 ; i < N ; i++){
            int now = arr[i];
            if(list.get(list.size() - 1) < now){
                list.add(now);
            } else{
                int index = binarySearch(now);
                list.set(index, now);
            }
        }
        System.out.println(list.size());
    }
}
