import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        
        for(String gem : gems) set.add(gem);
        
        int l = 0;
        int r = 0;
        int size = Integer.MAX_VALUE;
        for(String gem : gems){
            map.put(gem, map.getOrDefault(gem,0) + 1);
            while(map.get(gems[l]) > 1){
                map.put(gems[l],map.get(gems[l++]) - 1);
            }
            
            if(map.size() == set.size() && r - l < size){
                answer = new int[] {l+1,r+1};
                size = r - l;
            }
            r++;
        }
        
        
        
        return answer;
    }
}