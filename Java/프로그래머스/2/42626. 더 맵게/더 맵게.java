import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i1, i2) -> {return i1 - i2;}
        );
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            answer++;
            int f1 = pq.poll();
            int f2 = pq.poll();
            pq.offer(f1 + (f2 * 2));
        }
        
        if(pq.peek() < K){
            return -1;
        }
        return answer;
    }
}