class Solution {
    public static int calDistSquare(int x1, int y1, int x2, int y2){
        return (x1 - x2) * (x1 - x2)  + (y1 - y2) * (y1 - y2);
    }
    public int calMinDist(int m, int n, int x1, int y1, int x2, int y2){
        int minDist = Integer.MAX_VALUE;
        //위쪽 벽 대칭 (x1, y1 <-> x2, 2 * n - y2)
        if(!(x1 == x2 && y1 < y2)){
            minDist = Math.min(minDist, calDistSquare(x1, y1, x2, 2 * n - y2));
        }
        //아래쪽 벽 대칭 (x1, y1 <-> x2, -y2)
        if(!(x1 == x2 && y1 > y2)){
            minDist = Math.min(minDist, calDistSquare(x1, y1, x2, -y2));
        }
        //왼쪽 벽 대칭(x1, y1, -x2, y2)
        if(!(y1 == y2 && x1 > x2)){
            minDist = Math.min(minDist, calDistSquare(x1, y1, -x2, y2));
        } 
        //오른쪽 벽 대칭(x1, y1, 2 * m - x2, y2)
        if(!(y1 == y2 && x1 < x2)){
            minDist = Math.min(minDist, calDistSquare(x1, y1, 2 * m - x2, y2));
        }
        return minDist;
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int i = 0;
        for(int[] ball :  balls){
            answer[i ++] = calMinDist(m, n, startX, startY, ball[0], ball[1]);
        }
        return answer;
    }
}