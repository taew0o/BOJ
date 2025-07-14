import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static String findPassword(char[] str){
        Stack<Character> left = new Stack<>(), right = new Stack<>();//커서 기준 왼쪽, 오른쪽
        for(char c : str){
            switch (c){
                case '<':
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;
                case '>':
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;
                case '-':
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                default:
                    left.push(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : left){
            sb.append(c);
        }
        while (!right.isEmpty()){
            sb.append(right.pop());
        }
        return sb.toString();
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            sb.append(findPassword(br.readLine().toCharArray())).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
