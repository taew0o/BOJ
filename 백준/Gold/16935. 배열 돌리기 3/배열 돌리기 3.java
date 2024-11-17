import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R;
    static int[][] arr, temp;
    public static void changeArr(int funNum){
        temp = new int[N][M];
        switch (funNum){
            //상하 반전
            case 1 :
                for(int i = 0 ; i < N ; i++){
                    temp[i] = arr[N - i - 1];
                }
                break;
            //좌우 반전
            case 2 :
                for(int i = 0 ; i < N ; i++){
                    for(int j = 0 ; j < M ; j++){
                        temp[i][j] = arr[i][M - j - 1];
                    }
                }
                break;
            //오른쪽 90도 회전
            case 3 :
                temp = new int[M][N];
                for(int i = 0 ; i < M ; i++){
                    for(int j = 0 ; j < N ; j++){
                        temp[i][j] = arr[N - j - 1][i];
                    }
                }
                break;
            //왼쪽 90도 회전
            case 4 :
                temp = new int[M][N];
                for(int i = 0 ; i < M ; i++){
                    for(int j = 0 ; j < N ; j++){
                        temp[i][j] = arr[j][M - i - 1];
                    }
                }
                break;
            //1 -> 2, 2 -> 3, 3 -> 4 , 4 -> 1
            case 5 :
                //4 -> 1
                for(int i = 0 ; i < N / 2 ; i++){
                    for(int j = 0 ; j < M / 2 ; j++){
                        temp[i][j] = arr[i + N / 2][j];
                    }
                }
                //1 -> 2
                for(int i = 0 ; i < N / 2 ; i++){
                    for(int j = M / 2 ; j < M  ; j++){
                        temp[i][j] = arr[i][j - M / 2];
                    }
                }
                //2 -> 3
                for(int i = N / 2 ; i < N ; i++){
                    for(int j = M / 2 ; j < M ; j++){
                        temp[i][j] = arr[i - N / 2][j];
                    }
                }
                //3 -> 4
                for(int i = N / 2 ; i < N ; i++){
                    for(int j = 0 ; j < M / 2 ; j++){
                        temp[i][j] = arr[i][j + M / 2];
                    }
                }
                break;
            //1 -> 4, 4 -> 3, 3 -> 2 , 2 -> 1
            case 6 :
                //2 -> 1
                for(int i = 0 ; i < N / 2 ; i++){
                    for(int j = 0 ; j < M / 2 ; j++){
                        temp[i][j] = arr[i][j + M / 2];
                    }
                }
                //3 -> 2
                for(int i = 0 ; i < N / 2 ; i++){
                    for(int j = M / 2 ; j < M ; j++){
                        temp[i][j] = arr[i + N / 2][j];
                    }
                }
                //4 -> 3
                for(int i = N / 2 ; i < N ; i++){
                    for(int j = M / 2 ; j < M ; j++){
                        temp[i][j] = arr[i][j - M / 2];
                    }
                }
                //1 -> 4
                for(int i = N / 2 ; i < N ; i++){
                    for(int j = 0 ; j < M / 2 ; j++){
                        temp[i][j] = arr[i - N / 2][j];
                    }
                }
                break;
        }
        arr = temp;
        if(funNum == 3 || funNum == 4){
            int temp = N;
            N = M; M = temp;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (R --> 0){
            changeArr(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
