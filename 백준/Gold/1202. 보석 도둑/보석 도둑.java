import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jowel implements Comparable<Jowel> {
        int m,v;
        public Jowel(int m, int v){
            this.m = m;
            this.v = v;
        }

        //무게로 오름차순, 가격으로 내림차순
        @Override
        public int compareTo(Jowel o1) {
            return this.m == o1.m ? o1.v - this.v : this.m - o1.m;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Jowel[] jowels = new Jowel[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            jowels[i] = new Jowel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(jowels);

        int[] bags = new int[K];
        for(int i = 0 ; i < K ; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long sum = 0;
        int index_jowel = 0;
        Queue<Integer> containableJewels = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0 ; i < K ; i++){
            while (index_jowel < N){
                if(jowels[index_jowel].m <= bags[i]){
                    containableJewels.offer(jowels[index_jowel].v);
                    index_jowel++;
                }
                else{
                    break;
                }
            }
            if(!containableJewels.isEmpty()){
                sum += containableJewels.poll();
            }
        }
        System.out.println(sum);
    }
}
