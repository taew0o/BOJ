class Solution {
    static int[][] map = new int[3][3]; //-1 : 빈칸, 0 : O, 1 : X
    static int oCount = 0, xCount = 0;
    static int[][][] endPoints = {
        {{0,0}, {0,1}, {0,2}},
        {{1,0}, {1,1}, {1,2}},
        {{2,0}, {2,1}, {2,2}},
        {{0,0}, {1,0}, {2,0}},
        {{0,1}, {1,1}, {2,1}},
        {{0,2}, {1,2}, {2,2}},
        {{0,0}, {1,1}, {2,2}},
        {{0,2}, {1,1}, {2,0}}
    };
    static boolean isOWin(){
        for(int i = 0 ; i < 8 ; i++){
            boolean flag = true;
            for(int j = 0 ; j < 3 ; j++){
                int r = endPoints[i][j][0], c = endPoints[i][j][1];
                if(map[r][c] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
    static boolean isXWin(){
        for(int i = 0 ; i < 8 ; i++){
            boolean flag = true;
            for(int j = 0 ; j < 3 ; j++){
                int r = endPoints[i][j][0], c = endPoints[i][j][1];
                if(map[r][c] != 1){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
    public int solution(String[] board) {
        int answer = -1;
        //문제 경우
        //1. 게임 종료 x, oCount > xCount + 1
        //2. 게임 종료 x, xCount > oCount
        //3. o win, !(oCount == xCount + 1)
        //4. x win, !(oCount == xCount)
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                switch(board[i].charAt(j)){
                    case 'O':
                        oCount++;
                        map[i][j] = 0;
                        break;
                    case 'X' :
                        xCount++;
                        map[i][j] = 1;
                        break;
                    case '.':
                        map[i][j] = -1;
                        break;
                }
            }
        }
        boolean oWin = isOWin(), xWin = isXWin();
        if(!oWin && !xWin && (oCount > xCount + 1 || xCount > oCount)) return 0;
        else if(oWin && !(oCount == xCount + 1)) return 0;
        else if(xWin && !(oCount == xCount)) return 0;
        return 1;
    }
}