import java.io.*;

public class Main {
    public static boolean[] inOrOut;
    public static boolean divideAndConquer(int left, int right){
        if(left == right){
            return true;
        }
        int mid = (left + right) / 2;
        for(int i = left ; i < mid ; i++){
            if(inOrOut[i] == inOrOut[right - i]){
                return false;
            }
        }
        return divideAndConquer(left, mid - 1) && divideAndConquer(mid + 1, right);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            String str = br.readLine();
            int len = str.length();

            inOrOut = new boolean[len];
            for(int i = 0 ; i < len ; i++){
                inOrOut[i] = str.charAt(i) == '0';
            }

            sb.append(divideAndConquer(0, len - 1) ? "YES" : "NO").append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
