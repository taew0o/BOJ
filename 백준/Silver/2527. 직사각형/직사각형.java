import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] info;
    public static char getCode(){
        int x1 = info[0], y1 = info[1], p1 = info[2], q1 = info[3];
        int x2 = info[4], y2 = info[5], p2 = info[6], q2 = info[7];
        if(p1 < x2 || q1 < y2 || x1 > p2 || y1 > q2){
            return 'd';
        }
        else if((x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2)
                || (x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2)){
            return 'c';
        }
        else if(x1 == p2 || q1 == y2 || p1 == x2 || y1 == q2){
            return 'b';
        }
        return 'a';
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 4 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            info = new int[8];
            for(int j = 0 ; j < 8 ; j++){
                info[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(getCode()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
