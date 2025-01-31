import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Pole implements Comparable<Pole>{
        int index, height;
        public Pole(int index, int height){
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Pole o) {
            return o.height - this.height;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Pole[] poles = new Pole[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            poles[i] = new Pole(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(poles);

        int result = poles[0].height;
        int left = poles[0].index, right = poles[0].index;

        for(int i = 1 ; i < N ; i++){
            if(poles[i].index > right){
                result += poles[i].height * (poles[i].index - right);
                right = poles[i].index;
            }
            else if(poles[i].index < left){
                result += poles[i].height * (left - poles[i].index);
                left = poles[i].index;
            }
        }

        System.out.println(result);

    }
}
