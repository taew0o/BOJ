import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            String str = br.readLine();
            Queue<Character> queue = new LinkedList<>();
            boolean result = true;
            for(int i = 0 ; i < str.length() ; i++){
                char c = str.charAt(i);
                if(c == '('){
                    queue.offer(c);
                }
                else{
                    if(queue.isEmpty()){
                        result = false;
                        break;
                    }
                    else{
                        queue.poll();
                    }
                }
            }
            if(result && queue.isEmpty()){
                sb.append("YES").append('\n');
            }
            else{
                sb.append("NO").append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
