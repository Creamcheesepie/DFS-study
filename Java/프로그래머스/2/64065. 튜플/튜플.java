import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2,s.length() -2);
        String[] bits = s.split("\\},\\{");
        Arrays.sort(bits, (b1, b2) -> {return b1.length() - b2.length();});
        Set<String> set = new HashSet<>();
        
        int[] answer = new int[bits.length];
        int idx = 0;
        
        for(String bit : bits ){
            String[] tuple = bit.split(",");
            for(String element : tuple){
                if(set.add(element)) answer[idx++] = Integer.parseInt(element);
            }
            
        }
        
        return answer;
    }
}