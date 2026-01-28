import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, index;
    public static int[] inOrder, postOrder, preOrder;
    public static void divideAndConquer(int inStart, int postStart , int len){
        if(len == 0) return;
        //post Order에서 root의 위치 : postStart + len - 1;
        int root = postOrder[postStart + len - 1];
        preOrder[index ++] = root;
        //길이 1이라면 탐색 종료
        if(len == 1) return;
        //in order에서 root의 위치 찾기
        int inRootIndex = -1;
        for(int i = inStart ; i < inStart + len ; i++){
            if(inOrder[i] == root) {
                inRootIndex = i;
                break;
            }
        }
        int leftLen = inRootIndex - inStart, rightLen = (inStart + len - 1) - inRootIndex;
        //LEFT 탐색
        divideAndConquer(inStart, postStart, leftLen);
        //RIGHT 탐색
        divideAndConquer(inRootIndex + 1, postStart + leftLen, rightLen);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N =  Integer.parseInt(br.readLine());
        index = 0;
        inOrder = new int[N]; postOrder = new int[N]; preOrder = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine()), st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            inOrder[i] = Integer.parseInt(st1.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }
        divideAndConquer(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            sb.append(preOrder[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
