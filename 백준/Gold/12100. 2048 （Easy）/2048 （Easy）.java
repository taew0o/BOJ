import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static int max;
    public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
    static boolean flag;
    static boolean[][] merged;
    public static boolean moveAll(int dirNum){
        flag = false;
        merged = new boolean[N + 2][N + 2];
        switch(dirNum){
            case 0:
                for(int i = 1 ; i <= N ; i++){
                    for(int j = 1 ; j <= N ; j++){
                        move(dirs[0], i, j);
                    }
                }
                break;
            case 1:
                for(int i = N ; i >= 1 ; i--){
                    for(int j = 1 ; j <= N ; j++){
                        move(dirs[1], i, j);
                    }
                }
                break;
            case 2:
                for(int i = 1 ; i <= N ; i++){
                    for(int j = 1 ; j <= N ; j++){
                        move(dirs[2], i, j);
                    }
                }
                break;
            case 3:
                for(int i = 1 ; i <= N ; i++){
                    for(int j = N ; j >= 1 ; j--){
                        move(dirs[3], i, j);
                    }
                }
                break;
        }
        return flag;
    }
    public static void move(int[] dir, int r, int c){
        if(map[r][c] == 0) return;
        int nr = r, nc = c;
        while(map[nr + dir[0]][nc + dir[1]] == 0){
            nr += dir[0];
            nc += dir[1];
        }
        if(r == nr && c == nc && map[r][c] != map[r + dir[0]][nc + dir[1]]) return;
        if(map[r][c] == map[nr + dir[0]][nc + dir[1]] && !merged[nr + dir[0]][nc + dir[1]]){
            map[nr + dir[0]][nc + dir[1]] *= 2;
            map[r][c] = 0;
            merged[nr + dir[0]][nc + dir[1]] = true;
            max = Math.max(max, map[nr + dir[0]][nc + dir[1]]);
            flag = true;
        } else{
            if(r != nr || c != nc){
                map[nr][nc] = map[r][c];
                map[r][c] = 0;
                flag = true;
            }
        }
    }
    public static void dfs(int moveCount){
        if(moveCount == 5) return;
        for(int i = 0 ; i < 4 ; i++){
            int[][] backUp = new int[N + 2][N + 2];
            for(int j = 0 ; j <= N + 1; j++){
                backUp[j] = map[j].clone();
            }
            if(!moveAll(i)){
                for(int j = 0 ; j <= N + 1 ; j++){
                    map[j] = backUp[j].clone();
                }
                continue;
            }
            dfs(moveCount + 1);
            for(int j = 0 ; j <= N + 1 ; j++){
                map[j] = backUp[j].clone();
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        for(int i = 0 ; i <= N + 1 ; i++){
            map[0][i] = -1;
            map[N + 1][i] = -1;
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        dfs(0);
        System.out.println(max);
    }
}
