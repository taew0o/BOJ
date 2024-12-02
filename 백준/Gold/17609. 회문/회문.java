import java.io.*;

public class Main {
    static char[] str;
    public static int isPalindrome(int left, int right, boolean check){
        if(left >= right) return check ? 1 : 0;
        if(str[left] == str[right]){
            return isPalindrome(left + 1, right - 1, check);
        }
        else{
            if(check) return 2;
            else{
                int lResult = isPalindrome(left + 1 , right , true);
                int rResult = isPalindrome(left, right - 1, true);
                return lResult == 2 && rResult == 2 ? 2 : 1;
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while (N --> 0){
            str = br.readLine().toCharArray();
            sb.append(isPalindrome(0, str.length - 1, false)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
