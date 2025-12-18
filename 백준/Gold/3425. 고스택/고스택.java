import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class GoStack {
        Stack<Long> stack;
        ArrayList<String> opers;
        int[] V;
        BufferedReader br;
        public GoStack(ArrayList<String> opers, int[] V) {
            this.opers = opers;
            this.V = V;
            for(int i = 0; i < V.length; i++){
                sb.append(calResult(V[i])).append("\n");
            }
        }
        public String calResult(int start){
            stack = new Stack<>();
            stack.push((long) start);
            for(String oper : opers){
                if(operate(oper) == -1) return "ERROR";
            }
            return stack.size() == 1 ? String.valueOf(stack.peek()) : "ERROR";
        }
        public boolean outOfBound(long num){
            return Math.abs(num) > 1_000_000_000;
        }
        public int operate(String oper){
            long num = 0;
            if(oper.contains("NUM")) {
                String[] split =  oper.split(" ");
                oper = split[0];
                num = Integer.parseInt(split[1]);
            }
            long first, second, result;
            switch(oper){
                case "NUM" :
                    stack.push(num);
                    break;
                case "POP" :
                    if(stack.isEmpty()) return -1;
                    stack.pop();
                    break;
                case "INV" :
                    if(stack.isEmpty()) return -1;
                    stack.push(stack.pop() * -1);
                    break;
                case "DUP" :
                    if(stack.isEmpty()) return -1;
                    stack.push(stack.peek());
                    break;
                case "SWP" :
                    if(stack.size() < 2) return -1;
                    first = stack.pop(); second = stack.pop();
                    stack.push(first); stack.push(second);
                    break;
                case "ADD" :
                    if(stack.size() < 2) return -1;
                    result = stack.pop() + stack.pop();
                    if(outOfBound(result)) return -1;
                    stack.push(result);
                    break;
                case "SUB" :
                    if(stack.size() < 2) return -1;
                    first = stack.pop(); second = stack.pop();
                    result = (second - first);
                    if(outOfBound(result)) return -1;
                    stack.push(result);
                    break;
                case "MUL" :
                    if(stack.size() < 2) return -1;
                    result = (long) stack.pop() * stack.pop();
                    if(outOfBound(result)) return -1;
                    stack.push(result);
                    break;
                case "DIV" :
                    if(stack.size() < 2) return -1;
                    first = stack.pop(); second = stack.pop();
                    if(first == 0) return -1;

                    int sign = 1;
                    if((first < 0 && second > 0) || (first > 0 && second < 0)) sign = -1;

                    result = Math.abs(second) / Math.abs(first) * sign;

                    if(outOfBound(result)) return -1;
                    stack.push(result);
                    break;
                case "MOD" :
                    if(stack.size() < 2) return -1;
                    first = stack.pop(); second = stack.pop();
                    if(first == 0) return -1;

                    result = Math.abs(second) % Math.abs(first);
                    if(second < 0) result *= -1;
                    if(outOfBound(result)) return -1;
                    stack.push(result);
                    break;
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while (!(str = br.readLine()).equals("QUIT")) {
            ArrayList<String> opers = new ArrayList<>();
            while (!str.equals("END")) {
                opers.add(str);
                str = br.readLine();
            }
            int N = Integer.parseInt(br.readLine());
            int[] V = new int[N];
            for (int i = 0; i < N; i++) {
                V[i] = Integer.parseInt(br.readLine());
            }
            new GoStack(opers, V);
            br.readLine();
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
