class Solution {
    public int[] solution(int n) {
        int length = 0;
        for(int i = 1; i<=n ;i++) length += i;
        int[] answer = new int[length];
        
        int[][] triangle = new int[n][n];
        int x = -1;
        int y = 0;
        int cnt = 1;
        for(int dir = 0; dir<n; dir++){
            for(int j = dir; j<n; j++){
                if(dir % 3 == 0) x ++;
                else if(dir % 3 == 1) y ++;
                else {
                    x--;
                    y--;
                }
                triangle[x][y] = cnt++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i ; j++){
                if(triangle[i][j] > 0 ) answer[idx++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}