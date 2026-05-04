import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int colIndex = col - 1;
        
        Arrays.sort(data, (d1, d2) -> {
            if(d1[colIndex] == d2[colIndex]) return d2[0] - d1[0];
            else return d1[colIndex] - d2[colIndex];
        });
        
        int S_i = 0;
        for(int i = row_begin; i<=row_end; i++){
            for(int v : data[i-1]){
                S_i += v % i;
            }
            if(answer == 0) answer = S_i;
            else answer = answer ^ S_i;
            S_i = 0;
        }
        
        return answer;
    }
}