class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean flag = true;
        long ps = 0;
        long ms = 0;
        
        for(int n : sequence){
            if(flag){
                ps = Math.max((long)n, ps + n);
                ms = Math.max((long)-n, ms - n);
                flag = false;
            } else {
                ps = Math.max((long)-n, ps - n);
                ms = Math.max((long)n, ms + n);
                flag = true;
            }
            answer = Math.max(answer, Math.max(ps,ms));
        }
        
        return answer;
    }
}