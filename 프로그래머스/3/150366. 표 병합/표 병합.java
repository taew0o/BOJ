import java.util.*;
class Solution {
    public static int N;
    public static int[] p;
    public static String[] values;
    public static ArrayList<String> printResult;
    public static int find(int x){
        return x == p[x] ? x : (p[x] = find(p[x]));
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            p[pb] = pa;
        } else if(pb < pa){
            p[pa] = pb;
        }
    }
    public static void update(int r, int c, String value){
        int target = find(r * 50 + c);
        values[target] = value;
    }
    public static void update(String value1, String value2){
        for(int i = 0 ; i < N ; i++){
            if(values[i].equals(value1)){
                values[i] = value2;
            }
        }
    }
    public static void merge(int r1, int c1, int r2, int c2){
        if(r1 == r2 && c1 == c2) return;
        int p1 = find(r1 * 50 + c1);
        int p2 = find(r2 * 50 + c2);
        if(p1 == p2) return;
        if(!values[p1].equals("")){
            values[p2] = values[p1];
        } else{
            values[p1] = values[p2];
        }
        union(p1, p2);
    }
    public static void unmerge(int r, int c){
        int p1 = find(r * 50 + c);
        String value = values[p1];
        ArrayList<Integer> included = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(find(i) == p1){
                included.add(i);
            }
        }
        for(int idx : included){
            p[idx] = idx;
            values[idx] = "";
        }
        values[r * 50 + c] = value;
    }
    public static void print(int r, int c){
        int idx = find(r * 50 + c);
        printResult.add(values[idx].equals("") ? "EMPTY" : values[idx]);
    }

    public String[] solution(String[] commands) {
        N = 50 * 50;
        p = new int[N + 1];
        values = new String[N + 1];
        for(int i = 0 ; i <= N ; i++){
            p[i] = i;
            values[i] = "";
        }
        printResult = new ArrayList<>();
        for(String command : commands){
            StringTokenizer st = new StringTokenizer(command);
            String oper = st.nextToken();
            int r, c, r1, c1, r2, c2;
            String value, value1, value2;
            switch(oper){
                case "UPDATE":
                    if(st.countTokens() == 3){
                        r = Integer.parseInt(st.nextToken()) - 1; c = Integer.parseInt(st.nextToken()) - 1;
                        value = st.nextToken();
                        update(r, c, value);
                    } else{
                        value1 = st.nextToken(); value2 = st.nextToken();
                        update(value1, value2);
                    }
                    break;
                case "MERGE":
                    r1 = Integer.parseInt(st.nextToken()) - 1; c1 = Integer.parseInt(st.nextToken()) - 1;
                    r2 = Integer.parseInt(st.nextToken()) - 1; c2 = Integer.parseInt(st.nextToken()) - 1;
                    merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE":
                    r = Integer.parseInt(st.nextToken()) - 1; c = Integer.parseInt(st.nextToken()) - 1;
                    unmerge(r, c);
                    break;
                case "PRINT":
                    r = Integer.parseInt(st.nextToken()) - 1; c = Integer.parseInt(st.nextToken()) - 1;
                    print(r, c);
                    break;
            }
        }
        
        String[] answer = new String[printResult.size()];
        for(int i = 0 ; i < printResult.size() ; i++){
            answer[i] = printResult.get(i);
        }
        return answer;
    }
}