import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c) + 1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        ArrayList<Character> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);
        String left = "";
        String mid = "";
        String right = "";
        if(str.length() % 2 == 0){
            for(int i = 0 ; i < arrayList.size() ; i++){
                char c = arrayList.get(i);
                int len = hashMap.get(c);
                if(len % 2 != 0){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                else{
                    String half = String.valueOf(c).repeat(len / 2);
                    left = left + half;
                    right = half + right;
                }
            }
        }
        else{
            boolean isMidExist = false;
            for(int i = 0 ; i < arrayList.size() ; i++){
                char c = arrayList.get(i);
                int len = hashMap.get(c);
                if(len % 2 != 0){
                    if(isMidExist) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    }
                    else{
                        mid = String.valueOf(c);
                        String half = String.valueOf(c).repeat(len / 2);
                        left = left + half;
                        right = half + right;
                        isMidExist = true;
                    }
                }
                else{
                    String half = String.valueOf(c).repeat(len / 2);
                    left = left + half;
                    right = half + right;
                }
            }
        }
        System.out.println(left + mid + right);
    }
}
