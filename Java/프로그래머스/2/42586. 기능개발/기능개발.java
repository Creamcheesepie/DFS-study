class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int pIdx = 0;
        int time = 0;
        int pLength = progresses.length;
        int[] temp = new int[pLength];
        
        int tIdx = 0;
        while(pIdx < pLength){
            int complete = 0;
            while(pIdx < pLength && worked(progresses,speeds,pIdx,time)){
                pIdx++;
                complete ++;
            }
            if(complete > 0) temp[tIdx++] = complete;
            time++;
        }
        
        int[] answer = new int[tIdx];
        for(int i = 0; i<tIdx; i++){
            answer[i] = temp[i];
        }
        return answer;
    }
    
    private boolean worked(int[] progresses, int[] speeds,int pIdx, int time){
        int current= progresses[pIdx];
        int speed = speeds[pIdx] * time;
        return speed + current >= 100;
    }
}