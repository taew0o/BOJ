import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long res = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        return res == 0 ? 0 : res > 0 ? 1 : -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] p1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long x1 = p1[0], y1 = p1[1], x2 = p1[2], y2 = p1[3];
        long[] p2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long x3 = p2[0], y3 = p2[1], x4 = p2[2], y4 = p2[3];

        int abc = ccw(x1, y1, x2, y2, x3, y3), abd =  ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1), cdb = ccw(x3,  y3, x4, y4, x2, y2);

        int res1 = abc * abd, res2 = abd * abd;
        if(abc * abd <= 0 && cda * cdb <= 0){
            if(res1 == 0 && res2 == 0){
                long minX1 = Math.min(x1, x2), maxX1 = Math.max(x1, x2), minY1 =  Math.min(y1, y2), maxY1 = Math.max(y1, y2);
                long minX2 = Math.min(x3, x4), maxX2 = Math.max(x3, x4), minY2 = Math.min(y3, y4), maxY2 = Math.max(y3, y4);
                System.out.println(minX1 <= maxX2 && minX2 <= maxX1 && minY1 <= maxY2 && minY2 <= maxY1 ? "1" : "0");
            }
            else {
                System.out.println("1");
            }
        }else{
            System.out.println("0");
        }
    }
}
