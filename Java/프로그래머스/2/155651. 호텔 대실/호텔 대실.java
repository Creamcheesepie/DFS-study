import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 퇴실 시간 기준으로 입실시간이 더 빠르면 방을 추가<
        int answer = 1;
        int n = book_time.length;
        int[][] min_book = new int[n][2];
        for(int i = 0; i<n;i++){
            min_book[i] = bookTimeToMinuteArray(book_time[i]);
        }
        
        Arrays.sort(min_book, (m1,m2) -> m1[0]-m2[0]);
        // 방의 퇴실시간만 기록하면 된다!
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<n; i++){
            int inTime = min_book[i][0];
            int outTime = min_book[i][1] + 10;
            if(pq.isEmpty()) {
                pq.offer(outTime);
                continue;
            }
            if(inTime >= pq.peek()) pq.poll();
            pq.offer(outTime);
        }
        
        
        return pq.size();
    }
    
    private int[] bookTimeToMinuteArray(String[] time){
        int in = timeStringToMinute(time[0]);
        int out = timeStringToMinute(time[1]);
        return new int[] {in, out};
    }
    
    private int timeStringToMinute(String time){
        String[] bits = time.split(":");
        return (Integer.parseInt(bits[0]) * 60) + Integer.parseInt(bits[1]);
    }
}