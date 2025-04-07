import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class TrieNode{
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;
        public TrieNode(){

        }

        public void insert(String word){
            TrieNode trieNode = this;

            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);

                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);

                //단어가 끝나는 경우를 표시
                if(i==word.length() - 1){
                    trieNode.terminal = true;
                }
            }
        }

        public int autoCompletion(String word){
            TrieNode trieNode = this;
            int count = 0;
            for(int i = 0 ; i < word.length() ; i++){
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);
                //맨 처음 입력하는 경우, 단어가 완성되는 경우, 자식 노드가 2개 이상인 경우 추가 입력이 필요함.
                if(i == 0 || trieNode.terminal || trieNode.childNode.size() > 1){
                    count++;
                }
                trieNode = node;
            }
            return count;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        try{
            while (true) {
                int N = Integer.parseInt(br.readLine());

                String[] inputs = new String[N];
                TrieNode root = new TrieNode();

                for (int i = 0; i < N; i++) {
                    inputs[i] = br.readLine();
                    root.insert(inputs[i]);
                }

                double result = 0;
                for (String input : inputs) {
                    result += root.autoCompletion(input);
                }

                sb.append(String.format("%.2f", result / N)).append('\n');
            }

        } catch (NumberFormatException e){
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
