class Solution {
    public int solution(int[] stones, int k) {
        return binarySolution(stones,k);
    }
    
    private int binarySolution(int[] stones, int k){
        int answer = 0;
        // 최소 1명은 건널 수 있음
        int min = 1;
        // 최대로 건널 수 있는 인원의 수는 원소의 최댓값
        int max = 200_000_000;
        
        while(min <= max){
            // 중간 값
            int mid = (min + max) / 2;
            // 건널 수 있는지 여부 확인
            if(canCross(stones, k, mid)){
                // 건널 수 있다면 위쪽으로 2분탐색 진행
                answer = mid;
                min = mid + 1;
            } else{
                // 건널 수 없다면 적은쪼긍로 2분탐색 진행
                max = mid -1;
            }
        }
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid){
        int cnt = 0;
         for(int stone : stones){
             // mid보다 건널 수 있는 돌의 개수가 작을 때(해당 돌을 '건너뛰어야 할 때')
            if(stone < mid){
                cnt++;
                // k보다 cnt가 크거나 같으면 '한번에 뛰어 넘어도' 해당 구간을 건너지 못함
                if(cnt >= k) return false;
            } else {
                // 건넜다면 cnt를 0으로 초기화
                cnt = 0;
            }
        }
        // 
        return true;
    }
}