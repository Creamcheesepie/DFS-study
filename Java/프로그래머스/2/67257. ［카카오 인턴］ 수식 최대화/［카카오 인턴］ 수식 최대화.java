import java.util.*;

class Solution {
    public long solution(String expression) {
        List<String> list = getList(expression);
        
        return dfs(list);
    }
    
    private String[] marks = new String[] {"+","-","*"};
    private boolean[] checker = new boolean[3];
    private long dfs(List<String> list){
        if(list.size() == 1) return Long.parseLong(list.get(0));
        
        long maxRes = Long.MIN_VALUE;
        
        for(int i = 0; i<3; i++){
            if(!checker[i]){
                checker[i] = true;
                
                List<String> nextList = new ArrayList<>(list);
                calculator(marks[i],nextList);
                maxRes = Math.max(Math.abs(maxRes), Math.abs(dfs(nextList)));
                checker[i] = false; // 백트래킹
            }
        }
        return maxRes;
    }
    
    private void calculator(String mark, List<String> list){
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals(mark)){
                long front = Long.parseLong(list.get(i-1));
                long back = Long.parseLong(list.get(i+1));
                
                long res = switch (mark){
                        case "+" -> front + back;
                        case "-" -> front - back;
                        case "*" -> front * back;
                        default -> 0;
                };
                
                list.set(i - 1 , Long.toString(res));
                list.remove(i);
                list.remove(i);
                i--;
            }
        }
    }
    
    private List<String> getList(String str){
        int left = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                list.add(str.substring(left,i));
                list.add(str.substring(i,i+1));
                left = i+1;
            }
        }
        list.add(str.substring(left,str.length()));
        return list;
    }
}