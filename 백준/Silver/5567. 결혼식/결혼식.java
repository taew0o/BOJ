import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        while (M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); graph.get(b).add(a);
        }

        boolean isVisited[] = new boolean[N + 1];
        isVisited[1] = true;

        int result = 0;
        //상근이의 친구들 탐색
        for(int i = 0 ; i < graph.get(1).size() ; i++){
            int friend = graph.get(1).get(i);
            if(!isVisited[friend]) {
                isVisited[friend] = true;
                result++;
            }
            //상근이의 친구들의 친구들 탐색
            for(int j = 0 ; j < graph.get(friend).size() ; j++){
                int friendOfFriend = graph.get(friend).get(j);
                if(!isVisited[friendOfFriend]){
                    isVisited[friendOfFriend] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
