import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Order implements Comparable<Order> {
        int num, next;

        public Order(int num, int next) {
            this.num = num;
            this.next = next;
        }

        @Override
        public int compareTo(Order o) {
            // 가장 나중에(next가 큰 것) 등장하는 것이 우선순위가 높음 (먼저 poll 됨)
            return o.next - this.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] orders = new int[K];
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        // 멀티탭에 꽂힌 물건 관리 (번호 -> Order 객체)
        HashMap<Integer, Order> map = new HashMap<>();
        PriorityQueue<Order> pq = new PriorityQueue<>();
        int count = 0;

        for (int i = 0; i < K; i++) {
            int now = orders[i];

            // 1. 이미 멀티탭에 꽂혀 있는 경우
            if (map.containsKey(now)) {
                Order current = map.get(now);
                pq.remove(current); // 큐에서 제거 후
                current.next = findNext(orders, i, now); // 다음 위치 갱신
                pq.add(current); // 다시 삽입 (재정렬)
                continue;
            }

            // 2. 멀티탭에 빈 자리가 있는 경우
            if (map.size() < N) {
                Order newOrder = new Order(now, findNext(orders, i, now));
                map.put(now, newOrder);
                pq.add(newOrder);
            } 
            // 3. 자리가 없어서 하나를 뽑아야 하는 경우
            else {
                Order toRemove = pq.poll(); // 가장 나중에 쓰일 물건(next가 큰 것) 추출
                map.remove(toRemove.num);
                
                Order newOrder = new Order(now, findNext(orders, i, now));
                map.put(now, newOrder);
                pq.add(newOrder);
                count++;
            }
        }
        System.out.println(count);
    }

    // 현재 위치(idx) 이후로 target이 처음 나오는 인덱스를 반환
    private static int findNext(int[] orders, int idx, int target) {
        for (int i = idx + 1; i < orders.length; i++) {
            if (orders[i] == target) return i;
        }
        return Integer.MAX_VALUE; // 더 이상 나오지 않으면 무한대값
    }
}