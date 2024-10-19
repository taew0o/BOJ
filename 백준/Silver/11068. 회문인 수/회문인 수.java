import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arrayList;
    public static boolean isPalindrome(int n, int radix){
        arrayList = new ArrayList<>();
        while (n != 0){
            arrayList.add(n % radix);
            n /= radix;
        }
        for(int i = 0 ; i < arrayList.size() / 2; i++){
            if(arrayList.get(i) != arrayList.get(arrayList.size() - 1 - i)) return false;
        }
        return true;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < T ; t++){
            int N = Integer.parseInt(br.readLine());
            boolean check = false;
            for(int i = 2 ; i <= 64 ; i++){
                if(isPalindrome(N, i)){
                    check = true;
                    break;
                }
            }
            sb.append(check ? 1 : 0).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
