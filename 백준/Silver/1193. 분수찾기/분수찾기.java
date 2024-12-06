import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int r = 1, c = 1;
        final boolean LEFTBOTTOM = true, RIGHTTOP = false;

        boolean dist = LEFTBOTTOM;
        for(int i = 1 ; i < X ; i++){
            if(dist){
                if(r != 1){
                    r--;
                    c++;
                }
                else{
                    c++;
                    dist = RIGHTTOP;
                }
            }
            else{
                if(c != 1){
                    c--;
                    r++;
                }
                else{
                    r++;
                    dist = LEFTBOTTOM;
                }
            }
        }
        System.out.println(r + "/" + c);
    }
}
