import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String,Integer> dict = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<26; i++){
            dict.put(String.valueOf((char)('A'+i)),i+1);
        }
        
        int max = 27;
        for(int i = 0; i<msg.length();){
            int left = i;
            String temp = "";
            while(left<msg.length() && dict.containsKey(msg.substring(i,left + 1))){
                temp = msg.substring(i,left + 1);
                left++;
            }
            
            result.add(dict.get(temp));
            
            if(left<msg.length()) dict.put(msg.substring(i,left + 1),max++);
            
            i = left;
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}