import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        int zeroCount = 0;
        for(int i = 0 ; i < N ; i++){
            int next = Integer.parseInt(br.readLine());
            if(next > 0){
                pos.add(next);
            }
            else if(next == 0){
                zeroCount++;
            }
            else{
                neg.add(next);
            }
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        int sum = 0;
        for(int i = 0 ; i < pos.size() ; i++){
            if(i == pos.size() - 1){
                sum += pos.get(i);
                break;
            }
            if(pos.get(i + 1) > 1){
                sum += pos.get(i) * pos.get(i + 1);
            }
            else{
                sum += pos.get(i) + pos.get(i + 1);
            }
            i++;
        }

        for(int i = 0 ; i < neg.size() ; i++){
            if(i == neg.size() - 1){
                if(zeroCount == 0){
                    sum += neg.get(neg.size() - 1);
                }
                break;
            }
            sum += neg.get(i) * neg.get(i + 1);
            i++;
        }

        System.out.println(sum);
    }
}
