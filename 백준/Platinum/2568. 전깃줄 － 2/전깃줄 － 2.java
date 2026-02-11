import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Line implements Comparable<Line>{
        int a, b;
        public Line(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Line o) {
            return this.a - o.a;
        }
    }
    static int N;
    static Line[] lines;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    public static int binarySearch(int target){
        int left = 0, right = list.size();
        while (left < right){
            int mid = left + (right - left) / 2;
            if(target > list.get(mid)){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lines);
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = lines[i].b;
        }
        int[] record = new int[N];
        list = new ArrayList<>();
        list.add(arr[0]);
        record[0] = 0;
        for(int i = 1 ; i < N ; i++){
            int now = arr[i];
            if(now > list.get(list.size() - 1)){
                record[i] = list.size();
                list.add(now);
            } else{
                int index = binarySearch(now);
                list.set(index, now);
                record[i] = index;
            }
        }
        boolean[] isKeep = new boolean[N];
        int findIdx = list.size() - 1;
        for(int i = N - 1 ; i >= 0 ; i--){
            if(record[i] == findIdx){
                isKeep[i] = true;
                findIdx --;

            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N - list.size()).append('\n');
        for(int i = 0 ; i < N ; i++){
            if(!isKeep[i]){
                sb.append(lines[i].a).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
