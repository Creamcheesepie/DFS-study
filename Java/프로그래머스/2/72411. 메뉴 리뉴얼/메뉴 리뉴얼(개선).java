import java.util.*;

class Solution {
    int[] maxCount;
    Map<String,Integer>[] maps;
    
    public String[] solution(String[] orders, int[] course) {
        maxCount = new int[11];
        maps = new HashMap[11];
        for(int len : course){
            maps[len] = new HashMap<String,Integer>();
        }
        
        for(String order : orders){
            char[] temp = order.toCharArray();
            Arrays.sort(temp);
            
            for(int len : course){
                if(temp.length >= len){
                    genCombi(temp, 0,new StringBuilder(),len);
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        for(int len : course){
            int max = maxCount[len];
            if(max < 2) continue;
            
            for(Map.Entry<String, Integer> e : maps[len].entrySet()){
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
    
    private void genCombi(char[] charArr, int start, StringBuilder sb, int targetLen){
        if(sb.length() == targetLen){
            String res = sb.toString();
            int count = maps[targetLen].getOrDefault(res,0) + 1;
            maps[targetLen].put(res,count);

            maxCount[targetLen] = Math.max(maxCount[targetLen], count);
            return;
        }
        
        for(int i = start; i<charArr.length; i++){
            sb.append(charArr[i]);
            genCombi(charArr, i + 1, sb, targetLen);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
