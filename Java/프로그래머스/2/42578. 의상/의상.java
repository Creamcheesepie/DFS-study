import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // a,b := a, b + 1;
        Map<String, Integer> cntMap = new HashMap<>();
        
        for(String[] cloth : clothes){
            cntMap.put(cloth[1], cntMap.getOrDefault(cloth[1],0) + 1);
        }
        
        for(int cnt: cntMap.values()){
            answer*=(cnt+1);
        }
        
        answer --;
        return answer;
    }
}