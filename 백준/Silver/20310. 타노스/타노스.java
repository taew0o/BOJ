import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println("0".repeat(str.replaceAll("1", "").length() / 2)
                + "1".repeat(str.replaceAll("0", "").length() / 2));
    }
}

