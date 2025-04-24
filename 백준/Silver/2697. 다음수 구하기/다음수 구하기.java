import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            String str = br.readLine();
            boolean flag = false;
            for(int i = str.length() - 2 ; i >= 0 && !flag ; i--){
                for(int j = str.length() - 1 ; j > i ; j--){
                    if(str.charAt(i) < str.charAt(j)){
                        sb.append(str.substring(0, i));
                        sb.append(str.charAt(j));
                        for(int k = str.length() - 1 ; k > j ; k--){
                            sb.append(str.charAt(k));
                        }
                        sb.append(str.charAt(i));
                        for(int k = j - 1 ; k > i ; k--){
                            sb.append(str.charAt(k));
                        }
                        sb.append('\n');
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) sb.append("BIGGEST").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
