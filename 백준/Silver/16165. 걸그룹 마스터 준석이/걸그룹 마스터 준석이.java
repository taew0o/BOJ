import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, ArrayList<String>> groupToMember = new HashMap<>();
        HashMap<String, String> memberToGroup = new HashMap<>();

        while (N --> 0){
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            ArrayList<String> memberList = new ArrayList<>();
            while (num --> 0){
                String name = br.readLine();
                memberList.add(name);
                memberToGroup.put(name, group);
            }
            Collections.sort(memberList);
            groupToMember.put(group, memberList);
        }

        while (M --> 0){
            String keyword = br.readLine();
            int category = Integer.parseInt(br.readLine());
            //해당 멤버가 속한 팀 출력
            if(category == 1){
                sb.append(memberToGroup.get(keyword)).append('\n');
            }
            //해당 그룹의 모든 멤버 사전순 출력
            else{
                for(String member : groupToMember.get(keyword)){
                    sb.append(member).append('\n');
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
