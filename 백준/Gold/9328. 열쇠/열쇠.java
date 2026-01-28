import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int key;
    static ArrayList<int[]>[] lockedDoors;
    static int count;
    static int[] dr =  {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean isVaildCoord(int r, int c){
        return  r >= 0 && r <= N + 1 && c >= 0 && c <= M + 1;
    }
    static boolean containsKey(char c){
        return (key & (1 << (c - 'a'))) >= 1;
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        lockedDoors = new ArrayList[26];
        for(int i = 0 ; i < 26 ; i++){
            lockedDoors[i] = new ArrayList<>();
        }
        visited = new boolean[N + 2][M + 2];
        visited[0][0] = true;
        q.offer(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(isVaildCoord(nr, nc) && map[nr][nc] != '*' && !visited[nr][nc]){
                    char c =  map[nr][nc];
                    if(Character.isUpperCase(c)){
                        c = Character.toLowerCase(c);
                        if(containsKey(c)){
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }else{
                            lockedDoors[c - 'a'].add(new int[]{nr, nc});
                        }
                    }else{
                        if(Character.isLowerCase(c)){
                            key |= (1 << (c - 'a'));
                            for(int[] cord : lockedDoors[c - 'a']){
                                q.offer(new int[]{cord[0], cord[1]});
                                visited[cord[0]][cord[1]] = true;
                            }
                            lockedDoors[c - 'a'].clear();
                        } else if (c == '$'){
                            count++;
                        }
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N + 2][M + 2];
            for(int i = 0 ; i <= M + 1 ; i++){
                map[0][i] = '.';
                map[N + 1][i] = '.';
            }
            for(int i = 0 ; i <= N + 1 ; i++){
                map[i][0] = '.';
                map[i][M + 1] = '.';
            }
            for(int i = 1 ; i <= N ; i++){
                String str = br.readLine();
                for(int j = 1 ; j <= M ; j++){
                    map[i][j] = str.charAt(j-1);
                }
            }
            count = 0;
            key = 0;
            String keys = br.readLine();
            if(!keys.equals("0")){
                for(int i = 0 ; i < keys.length() ; i++){
                    key |= (1 << (keys.charAt(i) - 'a'));
                }
            }
            sb.append(bfs()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
