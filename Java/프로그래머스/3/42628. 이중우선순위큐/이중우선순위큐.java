import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(
            (i1, i2) -> {return i2 - i1;}
        );
        PriorityQueue<Integer> minQ = new PriorityQueue<>(
            (i1, i2) -> {return i1 - i2;}
        );
        
        for(String op : operations){
            String[] bits = op.split(" ");
            String command = bits[0];
            int num = Integer.parseInt(bits[1]);
            
            if(command.equals("I")){
                maxQ.offer(num);
                minQ.offer(num);
            } else if(command.equals("D")){
                if(maxQ.isEmpty() && minQ.isEmpty()) continue;
                if(num == 1){
                    minQ.remove(maxQ.poll());
                }else {
                    maxQ.remove(minQ.poll());
                }
            }
            
        }
        
        if(maxQ.isEmpty()) return new int[] {0,0};
        return new int[] {maxQ.poll(),minQ.poll()};
    }
}