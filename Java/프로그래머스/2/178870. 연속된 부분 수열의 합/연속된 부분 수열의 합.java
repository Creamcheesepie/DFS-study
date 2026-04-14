class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = new int[] {0, n};
        
        int l = 0;
        int sum = 0;
        int diff = n;
        for(int r = 0; r<n; r++){
            sum += sequence[r];
            
            
            while(sum > k) {
                sum -= sequence[l];
                l++;
            }
            if(sum == k && diff > r - l){
                answer[0] = l;
                answer[1] = r;
                diff = r - l;
            }
        }
        
        
        
        return answer;
    }
}