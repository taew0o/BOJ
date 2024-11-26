import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] crain = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            crain[i] = Integer.parseInt(st.nextToken());
        }
        
        //int 배열 내림차순 정렬
        crain = Arrays.stream(crain)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(box, Collections.reverseOrder());
        
        //가장 무게 제한이 큰 크레인이 현재 가장 무거운 box를 들 수 없다면 -1 출력 후 return.
        if(box.get(0) > crain[0]){
            System.out.println(-1);
            return;
        }
        

        int count = 0;
        while (!box.isEmpty()){
            //각 크레인이 해당 시점에 자신이 들 수 있는 가장 무거운 박스를 선택
            for(int i = 0 ; i < N ; i++){
                int len = box.size();
                if(len == 0) break;
                for(int j = 0 ; j < len ; j++){
                    if(crain[i] >= box.get(j)){
                        box.remove(j);
                        break;
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
