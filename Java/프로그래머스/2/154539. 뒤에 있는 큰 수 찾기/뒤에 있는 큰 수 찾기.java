import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {0,numbers[0]});
        for(int i = 1; i<numbers.length; i++){
            int current = numbers[i];
            
            while(true){
                int[] before = stack.peek();
                if(!stack.isEmpty() && before[1]<current){
                    answer[before[0]] = current; 
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[] {i,current});
        }
        return answer;
    }
}