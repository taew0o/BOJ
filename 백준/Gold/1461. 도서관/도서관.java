import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> plus = new ArrayList<>(), minus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int next = Integer.parseInt(st.nextToken());
            if(next < 0){
                minus.add(-next);
            }
            else if(next > 0){
                plus.add(next);
            }
        }

        //절대값이 큰 수부터 처리하기 위해 내림차순 정렬.
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int result = 0;

        //가장 먼 M개의 책 처리(편도)
        int index_plus = 0, index_minus = 0;

        //왕복 위치들 처리
        while (index_plus < plus.size()){
            result += plus.get(index_plus) * 2;
            index_plus += M;
        }

        while (index_minus < minus.size()){
            result += minus.get(index_minus) * 2;
            index_minus += M;
        }

        //최댓값 빼주기
        if(!plus.isEmpty() && (minus.isEmpty() || plus.get(0) > minus.get(0))){
            result -= plus.get(0);
        }
        else{
            result -= minus.get(0);
        }
        System.out.println(result);
    }
}
