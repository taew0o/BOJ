import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static Node[] tree;
    public static StringBuilder sb = new StringBuilder();
    public static class Node{
        char name;
        Node left,right;
        Node(char n){
            this.name = n;
        }
    }
    public static void preOrder(Node n){
        if(n != null){
            sb.append(n.name);
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    public static void inOrder(Node n){
        if(n != null){
            inOrder(n.left);
            sb.append(n.name);
            inOrder(n.right);
        }
    }
    public static void postOrder(Node n){
        if(n != null){
            postOrder(n.left);
            postOrder(n.right);
            sb.append(n.name);
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        StringTokenizer st;
        tree[0] = new Node('A');
        String left,right;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            Node n = tree[st.nextToken().charAt(0) - 'A'];
            left = st.nextToken(); right = st.nextToken();
            if(!left.equals(".")){
                tree[left.charAt(0) - 'A'] = new Node(left.charAt(0));
                n.left = tree[left.charAt(0) - 'A'];
            }
            if(!right.equals(".")){
                tree[right.charAt(0) - 'A'] = new Node(right.charAt(0));
                n.right = tree[right.charAt(0) - 'A'];
            }
        }
        preOrder(tree[0]);
        sb.append('\n');
        inOrder(tree[0]);
        sb.append('\n');
        postOrder(tree[0]);
        System.out.println(sb);
    }
}
