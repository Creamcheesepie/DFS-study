import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String,Integer> map1 = partMap(str1);
        Map<String,Integer> map2 = partMap(str2);
        Set<String> allKeys = new HashSet<>();
        
        for(String k : map1.keySet()) allKeys.add(k);
        for(String k : map2.keySet()) allKeys.add(k);
        
        int unionCnt = 0;
        int intersectionCnt = 0;
        for(String keys : allKeys){
            int cnt1 = map1.getOrDefault(keys,0);
            int cnt2 = map2.getOrDefault(keys,0);
            
            intersectionCnt += Math.min(cnt1,cnt2);
            unionCnt += Math.max(cnt1,cnt2);
        }
        
        if(unionCnt == 0) return 65536;
        
        
        double jak = (double)intersectionCnt / (double)unionCnt;
        jak *= 65536;
              
        return (int)Math.floor(jak);
    }
    
    private Map<String,Integer> partMap(String str){
        str = str.toLowerCase();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<str.length()-1; i++){
            String temp = str.substring(i,i+2);
            char c1 = temp.charAt(0);
            char c2 = temp.charAt(1);
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        return map;    
    }
}