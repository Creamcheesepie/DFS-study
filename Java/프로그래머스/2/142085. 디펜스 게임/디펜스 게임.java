import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (i1 , i2) -> i2 - i1 // 내림차순
        );
        
        for(int e : enemy){
            pq.offer(e);
            if(n < e){
                if(k > 0){
                    k --;
                    n += pq.poll();
                } else {
                    return answer;
                }
            }
            n -= e;
            answer++;
        }
        
        return answer;
    }
}