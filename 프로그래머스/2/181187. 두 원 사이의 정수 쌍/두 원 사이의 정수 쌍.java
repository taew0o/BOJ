class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x를 1부터 r2까지 순회 (y축 위의 점들은 나중에 따로 처리하거나 한 번에 포함)
        for (int x = 1; x <= r2; x++) {
            // 큰 원 안에서 x 좌표가 x일 때 가질 수 있는 최대 y (내림)
            long yMax = (long) Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            
            // 작은 원 안에서 x 좌표가 x일 때 가질 수 있는 최소 y (올림)
            // x가 r1보다 크면 작은 원 밖이므로 최소 y는 0
            long yMin = 0;
            if (x < r1) {
                yMin = (long) Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            }
            
            // 해당 x 라인에 존재하는 점의 개수
            answer += (yMax - yMin + 1);
        }
        
        // 1사분면 결과를 4배 (축 위의 점들 중 중복 처리를 위해 1부터 시작함)
        return answer * 4;
    }
}