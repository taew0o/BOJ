import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T --> 0){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(countPos(info[0],info[1],info[2],info[3],info[4],info[5])).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int countPos(int x1, int y1, int r1, int x2, int y2, int r2){
        //중심이 같은 경우
        if(x1 == x2 && y1 == y2){
            if(r1 == r2){
                return -1;
            }
            else{
                return 0;
            }
        }
        //중심이 다른 경우
        else{
            double dist = Math.sqrt(Math.pow(x1 - x2 , 2) + Math.pow(y1 - y2, 2)); //두 점 사이의 거리
            double rMax = Math.max(r1, r2), rMin = Math.min(r1, r2);
            //떨어져 있음.
            if(dist > rMax + rMin){
                return 0;
            }
            //외접
            else if(dist == rMax + rMin){
                return 1;
            }
            //교차
            else if(rMax - rMin < dist && dist < rMax + rMin){
                return 2;
            }
            //내접
            else if(dist == rMax - rMin){
                return 1;
            }
            //작은 원이 큰 원 안에 포함
            else{
                return 0;
            }
        }
    }
}
