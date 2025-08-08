import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int num;
        int min = 1, max = 10;
        boolean flag = true;
        while ((num = Integer.parseInt(br.readLine())) != 0){
            String answer = br.readLine();
            if (answer.equals("too high")){
                if (num - 1 < min) flag = false;
                max = Math.min(max, num - 1);
            }
            else if (answer.equals("too low")){
                if (num + 1 > max) flag = false;
                min = Math.max(min, num + 1);
            }
            else{
                if (num < min || num > max) flag = false;
                sb.append(flag ? "Stan may be honest" : "Stan is dishonest").append('\n');
                min = 1; max = 10;
                flag = true;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
