import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R,C,M;
    static boolean isVaildCoord(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C;
    }
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
    static class Shark{
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        public Shark move(){
            int nr = this.r + dr[this.d] * s, nc = this.c + dc[this.d] * s;
            if(isVaildCoord(nr, nc)){
                this.r = nr;
                this.c = nc;
            } else{
                if(nr < 0 || nr >= R){
                    int quotient = (Math.abs(nr) - 1) / (R - 1), remain = (Math.abs(nr) - 1) % (R - 1);
                    //아랫 방향
                    if(quotient % 2 == 0){
                        this.r = remain + 1;
                        this.d = 1;
                    }  else { //윗 방향
                        this.r = R - 1 - remain - 1;
                        this.d = 0;
                    }
                }
                if(nc < 0 || nc >= C){
                    int quotient = (Math.abs(nc) - 1) / (C - 1), remain = (Math.abs(nc) - 1) % (C - 1);
                    //오른쪽 방향
                    if(quotient % 2 == 0){
                        this.c = remain + 1;
                        d = 2;
                    } else{
                        this.c = C - 1 - remain - 1;
                        this.d = 3;
                    }
                }
            }
            return this;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        ArrayList<Shark> sharks = new ArrayList<Shark>();
        Shark[][] map = new Shark[R][C];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            sharks.add(shark);
            map[r][c] = shark;
        }
        int sum = 0;
        for(int c = 0 ; c < C ; c++){
            //해당 열의 가장 위에 있는 상어 잡기
            for(int r = 0 ; r < R ; r++){
                if(map[r][c] != null){
                    sum += map[r][c].z;
                    sharks.remove(map[r][c]);
                    map[r][c] = null;
                    break;
                }
            }
            //이동
            map = new Shark[R][C];
            ArrayList<Shark> removed = new ArrayList<Shark>();
            for(Shark shark : sharks){
                shark.move();
                if(map[shark.r][shark.c] != null){
                    if(map[shark.r][shark.c].z < shark.z){
                        removed.add(map[shark.r][shark.c]);
                        map[shark.r][shark.c] = shark;
                    } else{
                        removed.add(shark);
                    }
                } else{
                    map[shark.r][shark.c] = shark;
                }
            }
            for(Shark shark : removed){
                sharks.remove(shark);
            }
        }
        System.out.println(sum);
    }
}
