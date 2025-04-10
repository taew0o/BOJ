import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0 ; i < L ; i++){
            String student = br.readLine();
            //이미 존재했다면
            if(!set.add(student)){
                set.remove(student);
                set.add(student);
            }
        }

        Iterator<String> iterator = set.iterator();
        for(int i = 0 ; i < Math.min(K, set.size()); i++){
            sb.append(iterator.next()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
