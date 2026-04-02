import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        // 가장 큰 작업량을 까고 봐야함. -> 우선순위 큐 사용
        // 최댓값 -> 다음값만큼 까고 보기 
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i1, i2) -> {return i2 - i1;} // 내림차순
        );
        
        for(int i : works) pq.offer(i);
        
        
        while(n > 0){
            int max = pq.poll();
            if(max == 0) break;
            max --;
            n--;
            pq.offer(max);
        }
        
        for(int i : pq){
            answer += i * i;
        }
        
        return answer;
    }
}