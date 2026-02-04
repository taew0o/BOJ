import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static class State implements Comparable<State>{
        int[] arr;
        String arrStr;
        int cost;
        public State(int[] arr, int cost){
            this.arr = new int[arr.length];
            sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                this.arr[i] = arr[i];
                sb.append(this.arr[i]);
            }
            this.arrStr = sb.toString();
            this.cost = cost;
        }
        @Override
        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[][] oper = new int[M][3];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            oper[i][0] = Integer.parseInt(st.nextToken()) - 1;
            oper[i][1] = Integer.parseInt(st.nextToken()) - 1;
            oper[i][2] = Integer.parseInt(st.nextToken());
        }
        State root = new State(arr, 0);
        Arrays.sort(arr);
        State target = new State(arr, 0);
        HashMap<String, Integer> dist = new HashMap<>();
        Queue<State> q = new PriorityQueue<>();
        dist.put(root.arrStr, 0);
        q.add(root);
        while(!q.isEmpty()){
            State cur = q.poll();
            if(cur.arrStr.equals(target.arrStr)){
                System.out.println(cur.cost);
                return;
            }
            for(int i = 0 ; i < M ; i++){
                int[] newArr = cur.arr.clone();
                int temp = newArr[oper[i][0]];
                newArr[oper[i][0]] = newArr[oper[i][1]];
                newArr[oper[i][1]] = temp;
                State newState = new State(newArr, cur.cost + oper[i][2]);
                if(!dist.containsKey(newState.arrStr) || dist.get(newState.arrStr) > newState.cost){
                    dist.put(newState.arrStr, newState.cost);
                    q.add(newState);
                }
            }
        }
        System.out.println(-1);
    }
}
