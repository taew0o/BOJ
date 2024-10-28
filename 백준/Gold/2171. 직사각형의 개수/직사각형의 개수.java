import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> x = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> xToY = new HashMap<>();

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken()), ny = Integer.parseInt(st.nextToken());
            if(!xToY.containsKey(nx)){
                x.add(nx);
                xToY.put(nx, new ArrayList<>());
            }
            xToY.get(nx).add(ny);
        }
        Collections.sort(x);
        int xCount = x.size();
        long result = 0;
        for(int i1 = 0 ; i1 < xCount - 1; i1++){
            int x1 = x.get(i1);
            if(xToY.get(x1).size() == 1) continue;
            ArrayList<Integer> yX1 = xToY.get(x1);
            for(int i2 = i1 + 1 ; i2 < xCount ; i2++){
                int x2 = x.get(i2);
                if(xToY.get(x2).size() == 1) continue;
                ArrayList<Integer> yX2 = xToY.get(x2);
                for(int i3 = 0 ; i3 < yX1.size() - 1 ; i3++){
                    int y1 = yX1.get(i3);
                    for(int i4 = i3 + 1 ; i4 < yX1.size() ; i4++){
                        int y2 = yX1.get(i4);
                        if(yX2.contains(y1) && yX2.contains(y2)) result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
