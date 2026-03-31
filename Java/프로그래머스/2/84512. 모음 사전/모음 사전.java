import java.util.*;
class Solution {
    char[] characters = new char[] {'A','E','I','O','U'};
    int cnt = 0;
    Map<String, Integer> map = new HashMap<>();
    
    public int solution(String word) {
        dfs("");
        return map.get(word);
    }
    
    private void dfs(String current){
        
        map.put(current,cnt);
        cnt++;
        if(current.length() == 5) return;

        for(char c : characters){
            dfs(current+c);
        }
        
    }
}