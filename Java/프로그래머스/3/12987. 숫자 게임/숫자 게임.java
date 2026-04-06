import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int AIdx = 0;
        for(int b : B){
            if(A[AIdx] < b){
                answer++;
                AIdx++;
            }
        }
        
        return answer;
    }
}