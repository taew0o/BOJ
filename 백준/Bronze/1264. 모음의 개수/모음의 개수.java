import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        HashSet<Character> set = new HashSet<>();
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for(char c : vowels){
            set.add(c);
        }
        while (!(str = br.readLine()).equals("#")){
            int count = 0;
            for(int i = 0 ; i < str.length() ; i++){
                if(set.contains(str.charAt(i))){
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
