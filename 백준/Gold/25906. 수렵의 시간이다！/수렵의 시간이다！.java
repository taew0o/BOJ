import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] skillSize = new int[5];
        int[][] skills = new int[5][];
        for(int i = 0 ; i < 5 ; i++){
            st = new StringTokenizer(br.readLine());
            skillSize[i] = Integer.parseInt(st.nextToken());

            skills[i] = new int[skillSize[i] + 1]; //level이 0일 때 공격력 증가량을 0으로 하기 위함
            for(int j = 1 ; j <= skillSize[i] ; j++){
                skills[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] equipSize = new int[3];
        int[][] equipPrice = new int[3][];
        int[][][] equipSkill = new int[3][][];
        for(int i = 0 ; i < 3 ; i++){
            equipSize[i] = Integer.parseInt(br.readLine());

            equipPrice[i] = new int[equipSize[i] + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= equipSize[i] ; j++){
                equipPrice[i][j] = Integer.parseInt(st.nextToken());
            }

            equipSkill[i] = new int[equipSize[i] + 1][5];
            for(int j = 1 ; j <= equipSize[i] ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 5 ; k++){
                    equipSkill[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = 0;
        //i : 선택된 머리 방어구 , j : 선택된 상의 방어구, k : 선택된 하의 방어구
        for(int e1 = 0 ; e1 <= equipSize[0] ; e1++){
            for(int e2 = 0 ; e2 <= equipSize[1] ; e2++){
                for(int e3 = 0 ; e3 <= equipSize[2] ; e3++){
                    int price = equipPrice[0][e1] + equipPrice[1][e2] + equipPrice[2][e3];
                    if(price > N || price == 0) continue;
                    int[] levels = new int[5];
                    for(int i = 0 ; i < 5 ; i++){
                        levels[i] = equipSkill[0][e1][i] + equipSkill[1][e2][i] + equipSkill[2][e3][i];
                    }
                    //강화 할 수 있는 경우
                    if(price + K <= N){
                        for(int i = 0 ; i < 3 ; i++){
                            int e = i == 0 ? e1 : i == 1 ? e2 : e3;
                            if(e == 0) continue;
                            for(int l1 = 0 ; l1 < 5 ; l1++){
                                for(int l2 = 0 ; l2 < 5 ; l2++){
                                    if(equipSkill[i][e][l1] != 0 && l1 != l2 && equipSkill[i][e][l2] < skillSize[l2]){
                                        levels[l1]--; levels[l2]++;
                                        int sum = 0;
                                        for(int l = 0 ; l < 5 ; l++){
                                            int level = Math.min(skillSize[l], levels[l]);
                                            sum += skills[l][level];
                                        }
                                        result = Math.max(result, sum);
                                        levels[l1]++; levels[l2]--;
                                    }
                                }
                            }
                        }
                    }
                    //강화 할 수 없는 경우
                    else{
                        int sum = 0;
                        for(int l = 0 ; l < 5 ; l++){
                            int level = Math.min(skillSize[l], levels[l]);
                            sum += skills[l][level];
                        }
                        result = Math.max(result, sum);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
