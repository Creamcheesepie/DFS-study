class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int[] left = new int[10_001];
        int[] right = new int[10_001];
        int cntL = 0;
        int cntR = 0;
        
        for(int i = n -1; i> -1 ; i--){
            int t = topping[i];
            if(right[t] == 0) cntR ++;
            right[t] = right[t] + 1;
        }
        
        for(int i = 0; i<n; i++){
            int t = topping[i];
            if(left[t] == 0) cntL ++;
            left[t] = left[t] + 1;
            
            if(right[t] - 1 == 0 ) cntR --;
            right[t] = right[t] - 1;
            
            if(cntL == cntR) answer++;
        }
        
        return answer;
    }
}
