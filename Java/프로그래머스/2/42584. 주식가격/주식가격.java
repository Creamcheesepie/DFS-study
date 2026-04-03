class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int[] stack = new int[prices.length];
        int head = 0;
        for(int i = 0; i<prices.length; i++){
            while(head > 0 && prices[stack[head -1]] > prices[i]){
                answer[stack[head-1]] = i - stack[head-1];
                head--;
            }
            stack[head++] = i;
        }
        
        while(head > 0) {
            int tIdx = stack[--head];
            answer[tIdx] = prices.length - 1 - tIdx;
        }
        
        return answer;
    }
}