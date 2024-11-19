import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            words[i] = br.readLine();
            for(int j = 0 ; j < words[i].length() ; j++){
                char c = words[i].charAt(j);
                int digit = words[i].length() - j;
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, digit - 1));
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue((o1, o2) -> o2 - o1));

        int num = 9;
        for(Map.Entry e : entryList){
            for(int i = 0 ; i < N ; i++){
                words[i] = words[i].replaceAll(e.getKey().toString(), String.valueOf(num));
            }
            num--;
        }

        int result = 0;
        for(String word : words){
            result += Integer.parseInt(word);
        }
        System.out.println(result);
    }
}
