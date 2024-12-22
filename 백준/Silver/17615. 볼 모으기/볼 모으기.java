import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N <= 2){
            System.out.println(0);
            return;
        }
        String str = br.readLine();
        int red = 0, blue = 0;
        for(int i = 0 ; i < N ; i++){
            if(str.charAt(i) == 'R') red++;
            else blue++;
        }

        int result = Math.min(red, blue);
        char start = str.charAt(0), end = str.charAt(N - 1);
        for(int i = 1 ; i < N ; i++){
            if(str.charAt(i) != start){
                if(start == 'R'){
                    result = Math.min(result, red - i);
                }
                else{
                    result = Math.min(result, blue - i);
                }
                break;
            }
        }

        for(int i = N - 2 ; i >= 0 ; i--){
            if(str.charAt(i) != end){
                if(end == 'R'){
                    result = Math.min(result, red - (N - 1 - i));
                }
                else{
                    result = Math.min(result, blue - (N - 1 - i));
                }
                break;
            }
        }

        System.out.println(result);

    }
}
