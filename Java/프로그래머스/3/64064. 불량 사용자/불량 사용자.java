import java.util.*;

class Solution {
    Set<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        result = new HashSet<>();
        
        dfs(new HashSet<String>(), user_id,banned_id,0);
        
        return result.size();
    }
    
    private void dfs(Set<String> set, String[] user_id,String[] banned_id,int depth){
        if(depth == banned_id.length){
            result.add(new HashSet<>(set));
            return;
        }
        
        for(int i = 0; i<user_id.length; i++){
            String user = user_id[i];
            if(set.contains(user)) continue;
            
            if(matcher(user,banned_id[depth])){
                set.add(user);
                dfs(set,user_id,banned_id,depth + 1);
                set.remove(user);
            }
        }
    }
    
    private boolean matcher(String word,String pattern){
        if(word.length() != pattern.length()) return false;
        for(int i = 0; i<word.length(); i++){
            char t = pattern.charAt(i);
            char c = word.charAt(i);
            if(t != '*' && t != c) return false;
        }    
        return true;
    }
        
    
}