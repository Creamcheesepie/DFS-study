import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i : queue1) sum1 += i;
        for(int i : queue2) sum2 += i;
        
        Queue<Integer> q1 = arrayToQueue(queue1);
        Queue<Integer> q2 = arrayToQueue(queue2);
        
        // 그리디임
        if((sum1 + sum2) % 2 == 1) return -1; 
        long target = (sum1 + sum2) / 2;
        int maxOp = queue1.length * 4;
        
        while(sum1 != sum2 && answer <= maxOp){
            if(sum1 > sum2){
                int num1 = q1.poll();
                q2.offer(num1);
                sum1 -= num1;
                sum2 += num1;
            } else {
                int num2 = q2.poll();
                q1.offer(num2);
                sum2 -= num2;
                sum1 += num2;
            }
            answer++;
        }
        if(sum1 != sum2) return -1;
        return answer;
    }
    
    private Queue<Integer> arrayToQueue(int[] arr){
        Queue<Integer> deque = new LinkedList<>();
        for(int i : arr){
            deque.add(i);
        }
        return deque;
    }
}