import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0 ; i<bridge_length; i++) bridge.offer(0);
        
        int idx = 0;
        while(idx < truck_weights.length){
            time++;
            totalWeight -= bridge.poll();
            
            int nt = truck_weights[idx];
            
            if(totalWeight + nt <= weight){
                bridge.offer(nt);
                totalWeight += nt;
                idx++;
            } else{
                bridge.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}