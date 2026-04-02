class Solution {
    int solution(int[][] land) {
        int answer = 0;
        // 이거도 DP 활용해서 이전값에서 최대값을 가져와 저장하면서 진행하면 될 것 같은데
        int n = land.length;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<4; j++){
                int beforeMax = 0;
                for(int k = 0; k<4; k++){
                    if(j == k) continue;
                    beforeMax = Math.max(land[i-1][k],beforeMax);
                }
                land[i][j] += beforeMax;
            }
        }
        
        for(int i = 0; i<4; i++){
            answer = Math.max(land[n-1][i],answer);
        }
        return answer;
    }
}