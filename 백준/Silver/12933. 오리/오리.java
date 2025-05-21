import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> soundOrder = new HashMap<>();
        soundOrder.put('q', 0);
        soundOrder.put('u', 1);
        soundOrder.put('a', 2);
        soundOrder.put('c', 3);
        soundOrder.put('k', 4);

        String info = br.readLine();
        int[] ducks = new int[2500 + 1];
        int length = 0;
        for(int i = 0 ; i < info.length() ; i++){
            int next = soundOrder.get(info.charAt(i));
            boolean check = false;
            for(int j = 0 ; j < length ; j++){
                if((ducks[j] + 1) % 5 == next){
                    ducks[j] = (ducks[j] + 1) % 5;
                    check = true;
                    break;
                }
            }
            if(!check){
                if(next == 0){
                    length++;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
        }

        for(int i = 0 ; i < length ; i++){
            if(ducks[i] != 4){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(length);
    }
}
