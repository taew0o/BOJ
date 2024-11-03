import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Guest{
        int id, time;
        public Guest(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());

        Queue<Guest> queue = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            queue.offer(new Guest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int M = Integer.parseInt(br.readLine());
        HashMap<Integer, Guest> map = new HashMap<>();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            map.put(c, new Guest(p, t));
        }
        int time = 0;
        while (time < W){
            Guest first = queue.poll();
            if(first.time > T){
                if(time + T >= W){
                    while (time < W){
                        sb.append(first.id).append('\n');
                        time++;
                    }
                    break;
                }
                else{
                    for(int i = 1 ; i <= T ; i++){
                        sb.append(first.id).append('\n');
                        if(map.containsKey(time + i)){
                            queue.offer(map.get(time + i));
                        }
                    }
                    time += T;
                    first.time -= T;
                    queue.add(first);
                }
            } else{
                if(time + first.time >= W){
                    while (time < W){
                        sb.append(first.id).append('\n');
                        time++;
                    }
                    break;
                }
                else{
                    for(int i = 1 ; i <= first.time ; i++){
                        sb.append(first.id).append('\n');
                        if(map.containsKey(time + i)){
                            queue.offer(map.get(time + i));
                        }
                    }
                    time += first.time;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
