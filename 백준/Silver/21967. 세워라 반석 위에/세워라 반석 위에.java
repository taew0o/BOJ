import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1), minQueue = new PriorityQueue<>();
        maxQueue.offer(arr[0]);
        minQueue.offer(arr[0]);
        int left = 0 , right = 0;
        int max_len = 1;
        while (true){
            if(maxQueue.peek() - minQueue.peek() <= 2){
                max_len = Math.max(max_len, right - left + 1);
                right++;
                if(right == N){
                    System.out.println(max_len);
                    return;
                }
                maxQueue.offer(arr[right]);
                minQueue.offer(arr[right]);
            }
            else{
                maxQueue.remove(arr[left]);
                minQueue.remove(arr[left]);
                left++;
            }
        }

    }
}
