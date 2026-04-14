class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0,100000000};
        
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for(int right = 0; right<sequence.length; right ++){
            sum += sequence[right];
            while(sum > k) sum -= sequence[left++];
            if(sum == k) {
                int currentLength = right - left;
                if(currentLength < minLength){
                    minLength = currentLength;
                    answer[0] = left; answer[1] = right;
                }
            }
            
        }
        
        return answer;
    }
}