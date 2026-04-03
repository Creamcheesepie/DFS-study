import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        int box = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        
        while(box<=n){
            stack.push(box);
            
            while(!stack.isEmpty() && stack.peek() == order[answer]){
                stack.pop();
                answer++;
            }
            box ++;
        }
        
        return arraySolution(order);
    }
    
    private int arraySolution(int[] order){
        int idx = 0;
        int head = -1;
        int n = order.length;
        int stack[] = new int[n];
        int box = 1;
        while(box <= n){
            stack[++head] = box;
            
            while(head >= 0 && stack[head] == order[idx]){
                head --;
                idx++;
            }
            box++;
        }
        return idx;
    }
}