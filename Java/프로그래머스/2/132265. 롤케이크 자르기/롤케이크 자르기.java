import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        
        for(int i = n -1; i> -1 ; i--){
            int t = topping[i];
            right.put(t,right.getOrDefault(t,0) + 1);
        }
        
        for(int i = 0; i<n; i++){
            int t = topping[i];
            left.put(t, left.getOrDefault(t,0) +1);
            
            if(right.get(t) - 1 == 0 ) right.remove(t);
            else right.put(t,right.get(t) - 1);
            
            if(left.size() == right.size()) answer++;
        }
        
        return answer;
    }
}