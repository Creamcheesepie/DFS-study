class Solution {
    public int solution(int[][] triangle) {
        // 이거 DP 쓰는건데
        // int[i][x]이 고를 수 있는 최댓값은 int[i+1][x] or int[i+1][x+1];
        // bottom up으로 더 큰 수를 더해가며 올라가기
        for(int i = triangle.length - 2; i>-1; i--){
            int[] line = triangle[i];
            for(int j = 0; j<line.length ; j++){
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}