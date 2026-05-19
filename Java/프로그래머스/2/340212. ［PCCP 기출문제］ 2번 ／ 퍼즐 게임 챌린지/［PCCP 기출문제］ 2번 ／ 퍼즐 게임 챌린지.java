class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        int[][] puzzles = new int[n][2];
        // 이진탐색으로 찾아야 하나?
        int max = 0;
        int min = 1;
        
        for(int i = 0 ; i<n; i++){
            puzzles[i][0] = diffs[i];
            puzzles[i][1] = times[i];
            max = Math.max(diffs[i],max);
        }
        
        while(min <= max){
            int mid = (max + min) / 2;
            
            if(isPossible(puzzles,limit,mid)){
                max = mid -1;
                answer = mid;
            } else{
                min = mid + 1;
            }
        }
        

        
        return answer;
    }
    
    private boolean isPossible(int[][] puzzles, long limit, int level){
        long duration = 0;
        for(int i = 0; i<puzzles.length; i++){
            int diff = puzzles[i][0];
            int curTime = puzzles[i][1];
            
            if(diff <= level) duration += curTime;
            else {
                int wrongCnt = diff - level;
                int prevTime = i > 0 ? puzzles[i-1][1] : 0;
                duration += ((long)(curTime + prevTime) * wrongCnt) + curTime;
            }
            if(duration > limit) return false;
        }
        return true;
        
    }
}