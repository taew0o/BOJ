class Solution {
    public static int toSecond(int h, int m, int s){
        return h * 3600 + m * 60 + s;
    }
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSecond(h1, m1, s1), end = toSecond(h2, m2, s2);
        int hAngle = start % 43200, mAngle = (start % 3600) * 12, sAngle = (start % 60) * 720;
        int count = start == 0 || start == 43200 ? 1 : 0;
        for(int time = start + 1 ; time <= end ; time++){
            int nextH = time % 43200, nextM = (time % 3600) * 12, nextS = (time % 60) * 720;
            if(nextH == 0) nextH = 43200;
            if(nextM == 0) nextM = 43200;
            if(nextS == 0) nextS = 43200;
            if(sAngle < hAngle && nextS >= nextH) count++;
            if(sAngle < mAngle && nextS >= nextM) count++;
            if(nextS >= nextH && nextS >= nextM && nextM == nextH) count--;
            hAngle = nextH == 43200 ? 0 : nextH;
            mAngle = nextM == 43200 ? 0 : nextM;
            sAngle = nextS == 43200 ? 0 : nextS;
        }
        return count;
    }
}