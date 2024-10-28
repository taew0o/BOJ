import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isAbsolute(int num){
        return !(num == 1 || num == 2 || num == 3  || num == 5);
    }
    public static int calDigit(int num){
        String str = String.valueOf(num);
        int digit = 0;
        for(int i = 0 ; i < str.length() ; i++){
            digit += str.charAt(i) - '0';
        }
        return digit;
    }
    public static boolean isPrime(int num){
        if(num == 1 || num == 2){
            return true;
        }
        else{
            for(int i = 2; i < num ; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    //소인수 종류 개수 구하기
    public static int calPrime(int num){
        int result = 0;
        boolean is_prime[] = new boolean[num];
        for(int i = 2; i < num ; i++){
            is_prime[i] = isPrime(i);
        }
        for(int i = 2; i < num ; i++){
            if(is_prime[i] && num % i == 0){
                result++;
            }
        }
        return result;
    }
    //이면수인지
    public static boolean isLee(int num){
        return isAbsolute(num) && (calDigit(num) % 2 == 1);
    }
    //임현수인지
    public static boolean isLim(int num){
        int numPrime = calPrime(num);
        return (num == 2 || num == 4 || (numPrime != 0 && numPrime % 2 == 0));
    }
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        boolean is_lee = isLee(n);
        boolean is_lim = isLim(n);
        if(is_lee && is_lim){
            System.out.println(4);
        }
        else if(is_lee && !is_lim){
            System.out.println(1);
        }
        else if(!is_lee && is_lim){
            System.out.println(2);
        }
        else{
            System.out.println(3);
        }
    }
}
