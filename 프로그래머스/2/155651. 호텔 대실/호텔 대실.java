import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        for(int i = 0 ; i < book_time.length ; i++){
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            bookTime[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            bookTime[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        }
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        Queue<Integer> rooms = new PriorityQueue<>();
        int roomCount = 0;
        for(int[] book : bookTime){
            if(rooms.isEmpty() || rooms.peek() > book[0]){
                roomCount++;
                rooms.add(book[1] + 10);
            } else{
                rooms.poll();
                rooms.add(book[1] + 10);
            }
        }
        return roomCount;
    }
}