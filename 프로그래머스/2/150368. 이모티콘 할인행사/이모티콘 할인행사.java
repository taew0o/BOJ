class Solution {
    public static int N;
    public static int[][] users;
    public static int[] emoticons;
    public static int maxSubscriber;
    public static int maxSale;
    public static int[] saleInfo;
    public static void dfs(int index){
        if(index == N){
            int count = 0;
            int sale = 0;
            for(int[] user : users){
                int total = 0;
                for(int i = 0 ; i < N ; i++){
                    if(saleInfo[i] >= user[0]){
                        total += emoticons[i] - emoticons[i] * saleInfo[i] / 100;
                    }
                }
                if(total >= user[1]){
                    count++;
                } else{
                    sale += total;
                }
            }
            if(maxSubscriber < count){
                maxSubscriber = count;
                maxSale = sale;
            } else if(maxSubscriber == count){
                maxSale = Math.max(maxSale, sale);
            }
            return;
        }
        for(int percent = 10 ; percent <= 40 ; percent += 10){
            saleInfo[index] = percent;
            dfs(index + 1);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        N = emoticons.length;
        this.users = users;
        this.emoticons = emoticons;
        maxSubscriber = 0;
        maxSale = 0;
        saleInfo = new int[N];
        dfs(0);
        int[] answer = {maxSubscriber, maxSale};
        return answer;
    }
}