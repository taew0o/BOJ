class Solution {
    public static int N,M;
    public static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public static int[][] map;
    public static boolean[][] redVisited, blueVisited;
    public static int[] red = {0,0}, redTarget = {0,0}, blue = {0,0}, blueTarget = {0,0};
    public static int result = Integer.MAX_VALUE;
    public static void connect(int[] point, int r, int c){
        point[0] = r; point[1] = c;
    }
    public static boolean isValidCoord(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
    public static boolean isArrived(int[] now, int[] target){
        return now[0] == target[0] && now[1] == target[1];
    }
    public static void dfs(int turn){
        boolean isRedArrived = isArrived(red, redTarget);
        boolean isBlueArrived = isArrived(blue, blueTarget);
        if(isRedArrived && isBlueArrived){
            result = Math.min(result, turn);
            return;
        }
        else if(isRedArrived){
            for(int i = 0 ; i < 4 ; i++){
                int blueR = blue[0] + dr[i], blueC = blue[1] + dc[i];
                if(isValidCoord(blueR, blueC) && !blueVisited[blueR][blueC] && !(blueR == red[0] && blueC == red[1])){
                    int prevBlueR = blue[0], prevBlueC = blue[1];
                    blue[0] = blueR; blue[1] = blueC;
                    blueVisited[blueR][blueC] = true;
                    dfs(turn + 1);
                    blue[0] = prevBlueR; blue[1] = prevBlueC;
                    blueVisited[blueR][blueC] = false;
                }
            }
        } else if(isBlueArrived){
            for(int i = 0 ; i < 4 ; i++){
                int redR = red[0] + dr[i], redC = red[1] + dc[i];
                if(isValidCoord(redR, redC) && !redVisited[redR][redC] && !(redR == blue[0] && redC == blue[1])){
                    int prevRedR = red[0], prevRedC = red[1];
                    red[0] = redR; red[1] = redC;
                    redVisited[redR][redC] = true;
                    dfs(turn + 1);
                    red[0] = prevRedR; red[1] = prevRedC;
                    redVisited[redR][redC] = false;
                }
            }
        } else{
            for(int i = 0 ; i < 4 ; i++){
                int redR = red[0] + dr[i], redC = red[1] + dc[i];
                if(!isValidCoord(redR, redC) || redVisited[redR][redC]) continue;
                for(int j = 0 ; j < 4 ; j++){
                    int blueR = blue[0] + dr[j], blueC = blue[1] + dc[j];
                    if(!isValidCoord(blueR, blueC) || blueVisited[blueR][blueC]) continue;
                    //가려는 위치가 같거나 서로 뒤바뀌는 경우
                    if((redR == blueR && redC == blueC) 
                       || (redR == blue[0] && redC == blue[1] && blueR == red[0] && blueC == red[1])) continue;
                    int prevRedR = red[0], prevRedC = red[1], prevBlueR = blue[0], prevBlueC = blue[1];
                    red[0] = redR; red[1] = redC; blue[0] = blueR; blue[1] = blueC;
                    redVisited[redR][redC] = true; blueVisited[blueR][blueC] = true;
                    dfs(turn + 1);
                    red[0] = prevRedR; red[1] = prevRedC; blue[0] = prevBlueR; blue[1] = prevBlueC;
                    redVisited[redR][redC] = false; blueVisited[blueR][blueC] = false;
                }
            }
        }
    }
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        this.map = maze;
        redVisited = new boolean[N][M]; blueVisited = new boolean[N][M];
        int[][] arrays = {red, blue, redTarget, blueTarget};
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(1 <= map[i][j] && map[i][j] <= 4){
                    int idx = map[i][j] - 1;
                    connect(arrays[idx], i, j);
                } else if(map[i][j] == 5){
                    redVisited[i][j] = true;
                    blueVisited[i][j] = true;
                }
            }
        }
        redVisited[red[0]][red[1]] = true;
        blueVisited[blue[0]][blue[1]] = true;
        dfs(0);
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}