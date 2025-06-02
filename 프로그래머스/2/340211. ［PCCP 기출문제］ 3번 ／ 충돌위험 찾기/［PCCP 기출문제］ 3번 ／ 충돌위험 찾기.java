class Solution {
    public void move(int r1, int c1, int r2, int c2, int time, int[][][] count){
        //r좌표 변하는 이동 기록
        while (r1 != r2){
            r1 += r1 < r2 ? 1 : -1;
            count[r1][c1][time]++;
            time++;
        }
        //c좌표 변하는 이동 기록
        while (c1 != c2){
            c1 += c1 < c2 ? 1 : -1;
            count[r1][c1][time]++;
            time++;
        }
    }
    public int solution(int[][] points, int[][] routes) {
        for(int[] point : points){
            point[0]--;
            point[1]--;
        }
        for(int[] route : routes){
            for(int i = 0 ; i < route.length ; i++){
                route[i]--;
            }
        }

        int max_time = 0;
        for(int[] route : routes){
            int time = 0;
            for(int i = 0 ; i < route.length - 1 ; i++){
                int now = route[i], next = route[i + 1];
                time += Math.abs(points[now][0] - points[next][0])
                        + Math.abs(points[now][1] - points[next][1]);
            }
            max_time = Math.max(max_time, time);
        }

        int[][][] count = new int[100][100][max_time + 1];
        for(int[] route : routes){
            count[points[route[0]][0]][points[route[0]][1]][0]++;
        }
        for(int[] route : routes){
            int time = 1;
            for(int i = 0 ; i < route.length - 1 ; i++){
                int prev = route[i], next = route[i + 1];
                move(points[prev][0], points[prev][1], points[next][0], points[next][1],
                        time, count);
                time += Math.abs(points[prev][0] - points[next][0])
                        + Math.abs(points[prev][1] - points[next][1]);
            }
        }

        int result = 0;
        for(int r = 0 ; r < 100 ; r++){
            for(int c = 0 ; c < 100 ; c++){
                for(int t = 0 ; t <= max_time ; t++){
                    if(count[r][c][t] > 1){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}