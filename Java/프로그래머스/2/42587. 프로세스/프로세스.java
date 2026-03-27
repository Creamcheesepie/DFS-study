class Solution {
    public int solution(int[] priorities, int location) {
        int[] pCnt = new int[10];
        int maxP = 0;
        int answer = 0;
        
        for(int i : priorities){
            pCnt[i] = pCnt[i] + 1;
            maxP = Math.max(i,maxP);
        }
        
        int idx = 0;
        while(true){
            if(priorities[idx] == maxP){
                
                pCnt[maxP] = pCnt[maxP] -1;
                while(pCnt[maxP] == 0 && maxP > 1) maxP--;
                answer++;
                if(idx == location){
                    break;
                }
            }
            idx++;
            idx = idx % priorities.length;
        }
        
        
        
        return answer;
    }
}