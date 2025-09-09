import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> posSet = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++){
                int num = Integer.parseInt(st.nextToken());
                posSet.add(num);
            }
            ArrayList<Integer> posList = new ArrayList<>(posSet);
            Collections.sort(posList);
            int count = 0;
            for(int mid = 1 ; mid < posList.size() - 1 ; mid++){
                for(int left = 0 ; left < mid ; left++){
                    int rightNum = 2 * posList.get(mid) - posList.get(left);
                    if (posSet.contains(rightNum)){
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
