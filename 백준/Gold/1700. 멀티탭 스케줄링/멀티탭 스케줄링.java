import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] orders = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isOn = new boolean[K + 1]; // 현재 멀티탭에 꽂혀있는지 확인
        int putCount = 0; // 멀티탭에 꽂힌 개수
        int result = 0;

        for (int i = 0; i < K; i++) {
            int now = orders[i];

            // 1. 이미 꽂혀있는 경우
            if (isOn[now]) continue;

            // 2. 빈 자리가 있는 경우
            if (putCount < N) {
                isOn[now] = true;
                putCount++;
            } 
            // 3. 자리가 없어서 하나를 빼야 하는 경우
            else {
                int target = -1;
                int lastIdx = -1;

                // 멀티탭에 꽂힌 것들 중 무엇을 뺄지 결정
                for (int j = 1; j <= K; j++) {
                    if (isOn[j]) { // 꽂혀있는 물건들에 대해
                        int nextIdx = Integer.MAX_VALUE;
                        
                        // 현재 시점(i) 이후로 가장 빨리 등장하는 위치 찾기
                        for (int k = i + 1; k < K; k++) {
                            if (orders[k] == j) {
                                nextIdx = k;
                                break;
                            }
                        }
                        
                        // 나중에 아예 안 쓰이거나(MAX_VALUE), 가장 나중에 쓰이는 것 선택
                        if (nextIdx > lastIdx) {
                            lastIdx = nextIdx;
                            target = j;
                        }
                    }
                }
                
                isOn[target] = false; // 타겟 뽑기
                isOn[now] = true;    // 새 물건 꽂기
                result++;
            }
        }
        System.out.println(result);
    }
}