import java.io.*;

public class Main {
    public static int N;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();
    static String recurion(int r, int c, int size){
        if(size == 1){
            return String.valueOf(map[r][c]);
        }
        String lt = recurion(r,c,size / 2), rt = recurion(r, c + size / 2 , size / 2)
                , lb = recurion(r + size / 2 , c , size / 2), rb = recurion(r + size / 2, c + size / 2 , size / 2);
        if(lt.equals("1") && rt.equals("1") && lb.equals("1") && rb.equals("1")){
            return "1";
        }
        if (lt.equals("0") && rt.equals("0") && lb.equals("0") && rb.equals("0")) {
            return "0";
        }
        return String.format("(%s%s%s%s)",lt,rt,lb,rb);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bw.write(recurion(0,0,N));
        bw.flush();
    }
}
