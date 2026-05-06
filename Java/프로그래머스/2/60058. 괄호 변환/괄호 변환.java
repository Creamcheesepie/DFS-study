import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    

    private String dfs(String s){
        if(s.length() == 0) return s;
        
        String u = "";
        String v = "";
        int open = 0;
        int close = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(') open ++;
            else close ++;
            
            if(open > 0 && close > 0 && open == close){
                u = s.substring(0,i+1);
                if(i < s.length() - 1) v = s.substring(i+1,s.length());
                break;
            }
        }
        
        if(isCorrect(u)) return u + dfs(v);
        else {
            String temp = "(" + dfs(v) + ")";
            u = u.substring(1,u.length()-1);
            u = u.replace("(",".");
            u = u.replace(")","(");
            u = u.replace(".",")");
            temp = temp + u;
            return temp;
        }
    }
    
    private boolean isCorrect(String p){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i<p.length(); i++){
            char current = p.charAt(i);
            if(current == '(') stack.push(current);
            else if(stack.isEmpty()) return false;
            else if(stack.peek() == '(') stack.pop();
        }
        
        if(stack.isEmpty())return true;
        else return false;
    }
    
    private boolean isValanced(String p){
        int open = 0;
        int close = 0;
        
        for(int i = 0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c == '(') open++;
            else close ++;
        }
        return open == close;
    }
}