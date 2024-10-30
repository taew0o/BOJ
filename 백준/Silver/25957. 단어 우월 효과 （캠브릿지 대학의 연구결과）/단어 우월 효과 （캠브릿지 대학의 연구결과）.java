import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static String getStandard(String word){
        int len = word.length();

        if(len <= 3){
            return word;
        }
        else{
            char[] mid = word.substring(1, len - 1).toCharArray();
            Arrays.sort(mid);
            return word.charAt(0) + new String(mid) + word.charAt(len - 1);
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> translator = new HashMap<>();

        while (N --> 0){
            String word = br.readLine();
            translator.put(getStandard(word), word);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (M --> 0){
            sb.append(translator.get(getStandard(st.nextToken()))).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
