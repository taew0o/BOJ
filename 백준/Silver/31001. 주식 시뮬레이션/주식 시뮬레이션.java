import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, ArrayList<String>> groupMap = new HashMap<>();
        HashMap<String, Integer> priceMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int groupId = Integer.parseInt(st.nextToken());
            String companyName = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            if(!groupMap.containsKey(groupId)){
                groupMap.put(groupId, new ArrayList<>());
            }
            groupMap.get(groupId).add(companyName);

            priceMap.put(companyName, price);
            countMap.put(companyName, 0);
        }

        while (Q --> 0){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            String A;
            int B,C,D,E;
            switch (op){
                case 1 :
                    A = st.nextToken(); B = Integer.parseInt(st.nextToken());
                    if(M >= (long) B * priceMap.get(A)){
                        M -= (long) B * priceMap.get(A);
                        countMap.put(A, countMap.get(A) + B);
                    }
                    break;
                case 2 :
                    A = st.nextToken(); B = Integer.parseInt(st.nextToken());
                    if(countMap.get(A) != 0){
                        B = Math.min(B, countMap.get(A));
                        M += (long) B * priceMap.get(A);
                        countMap.put(A, countMap.get(A) - B);
                    }
                    break;
                case 3 :
                    A = st.nextToken(); C = Integer.parseInt(st.nextToken());
                    priceMap.put(A, priceMap.get(A) + C);
                    break;
                case 4 :
                    D = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
                    for(String company : groupMap.get(D)){
                        priceMap.put(company, priceMap.get(company) + C);
                    }
                    break;
                case 5 :
                    D = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
                    for(String company : groupMap.get(D)){
                        int nextPrice = (int)((double) priceMap.get(company) * (100 + E) / 100);
                        //일의 자리 버림
                        nextPrice -= nextPrice % 10;
                        priceMap.put(company, nextPrice);
                    }
                    break;
                case 6 :
                    sb.append(M).append('\n');
                    break;
                case 7 :
                    long now = M;
                    for(Map.Entry<String, Integer> entry : countMap.entrySet()){
                        now += (long) entry.getValue() * priceMap.get(entry.getKey());
                    }
                    sb.append(now).append('\n');
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
