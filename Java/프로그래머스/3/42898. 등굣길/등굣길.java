class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        
        for(int[] puddle : puddles){
            int pm = puddle[0];
            int pn = puddle[1];
            map[pn-1][pm-1] = -1;
        }
        
        map[0][0] = 1;
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j] == -1) continue;
                if(i == 0 && j == 0) continue;
                
                int up = 0;
                int left = 0;
                if(i - 1 > -1 && map[i-1][j] != -1) up = map[i-1][j];
                if(j - 1 > -1 && map[i][j-1] != -1) left = map[i][j-1];
                map[i][j] = (up + left) % 1000000007;
            }
        }
        return map[n-1][m-1];
    }
}