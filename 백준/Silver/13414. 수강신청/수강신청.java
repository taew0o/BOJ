import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> info = new HashMap<>();
        String[] list = new String[L];
        for(int i = 0 ; i < L ; i++){
            list[i] = br.readLine();
            info.put(list[i], info.getOrDefault(list[i], 0) + 1);
        }

        int count = 0;//수강신청 성공한 학생의 수
        for(int i = 0 ; i < L ; i++){
            info.put(list[i], info.get(list[i]) - 1);
            if(info.get(list[i]) == 0){
                count++;
                sb.append(list[i]).append('\n');
                info.remove(list[i]);
            }
            if(count == K) break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
