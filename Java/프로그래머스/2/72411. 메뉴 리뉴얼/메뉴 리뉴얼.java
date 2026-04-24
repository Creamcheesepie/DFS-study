import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i<orders.length; i++){
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = new String(temp);
        }
        
        for(int len : course){
             Map<String,Integer> map = new HashMap<>();
            
            for(String order : orders){
                if(order.length() >= len){
                    dfs(order,"",0,len,map);
                }
            }
            
            int max = Integer.MIN_VALUE;
            for(int v : map.values()){
                max = Math.max(v,max);
            }
            if(max < 2) continue;
            
            for(Map.Entry<String, Integer> e : map.entrySet()){
                if(e.getValue() == max) result.add(e.getKey());
            }
        }
                
        String[] answer = new String[result.size()];
        for(int i = 0; i<result.size() ; i++){
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    private void dfs(String order, String res, int start, int targetLen, Map<String,Integer> map){
        if(res.length() == targetLen){
            map.put(res, map.getOrDefault(res,0) + 1);
            return;
        }
        
        for(int i = start; i<order.length(); i++){
            dfs(order, res + order.charAt(i),i+1, targetLen, map);
        }
    }
}