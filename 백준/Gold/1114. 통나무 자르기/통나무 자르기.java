import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L,K,C;
    static int[] allPos;
    static int firstCut;
    public static void binarySearch(){
        int left = 1 , right = L;
        while (left <= right){
            int mid = (left + right) / 2;
            if (isAvailable(mid)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(left + " " + firstCut);
    }
    //모든 조각난 통나무의 길이가 mid 이하인가?
    public static boolean isAvailable(int len){
        int prev = L; //이전에 자른 위치
        int first = -1; //첫 번째로 자른 위치
        int remain = C; //남은 자르기 횟수
        for(int i = K ; i >= 0 ; i--){
            int now = allPos[i];
            if(prev - now <= len){
                if(now != 0 && remain > 0){
                    first = now;
                }
            }
            else{
                if(i == K || remain == 0) return false;
                now = allPos[++i];
                if(prev - now <= len){
                    prev = now;
                    remain--;
                    first = now;
                }
                else{
                    return false;
                }
            }
        }
        firstCut = first;
        return true;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        allPos = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= K ; i++){
            allPos[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(allPos);
        binarySearch();
    }
}
