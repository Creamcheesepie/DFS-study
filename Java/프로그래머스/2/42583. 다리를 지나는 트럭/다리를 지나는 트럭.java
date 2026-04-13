import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<bridge_length; i++){
            deque.offer(0);
        }
        
        int idx = 0;
        int currentWeight = 0;
        while(idx < truck_weights.length){
            answer++;
            currentWeight -= deque.poll();
            
            if(currentWeight + truck_weights[idx] <= weight){
                currentWeight += truck_weights[idx];
                deque.offer(truck_weights[idx]);
                idx++;
            } else{
                deque.offer(0);
            }
        }
        // 마지막 트럭이 출발점에 있으니 길이 만큼 더해줌(마지막 트럭이 나오는 시간)
        return answer + bridge_length;
    }
}