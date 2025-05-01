import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int remain0 = str.replaceAll("1", "").length() / 2;
        int remain1 = str.replaceAll("0", "").length() / 2;

        StringBuilder sb = new StringBuilder(str);
        //1은 앞에서부터, 0은 뒤에서부터
        int index = 0;
        while (remain1 != 0){
            if(sb.charAt(index) == '1'){
                sb.deleteCharAt(index);
                remain1--;
                continue;
            }
            index++;
        }

        index = sb.length() - 1;
        while (remain0 != 0){
            if(sb.charAt(index) == '0'){
                sb.deleteCharAt(index);
                remain0--;
            }
            index--;
        }

        System.out.println(sb.toString());
    }
}

