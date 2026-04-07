class Solution {
    public int[] solution(int n, int s) {
        if(n == 1) return new int[]{s};
        if(n > s) return new int[] {-1};
        
        int div = s / n;
        int rest = s % n;
        int[] answer= new int[n];
        for(int i = n -1; i> -1; i--){
            answer[i] = div;
            if(rest-- > 0) answer[i] ++;
        }
        return answer;
    }
}