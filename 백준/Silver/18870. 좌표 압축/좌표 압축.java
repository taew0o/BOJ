import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<Integer> list;
    public static int binarySearch(int left , int right, int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int value = list.get(mid);
        if(value == target){
            return mid;
        }
        else if(value < target){
            return binarySearch(mid + 1, right, target);
        }
        else{
            return binarySearch(left, mid - 1, target);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }
        list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0 ; i < N ; i++){
            sb.append(binarySearch(0, list.size() - 1 , arr[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}