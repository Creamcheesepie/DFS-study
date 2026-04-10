import java.util.*;

class Solution {
    public int solution(String numbers) {
        return dfs("",numbers,new boolean[numbers.length()],new HashSet<Integer>());
    }
    
    private int dfs(String now,String numbers,boolean[] visited,Set<Integer> counter){
        if(!now.isBlank() && !counter.contains(Integer.parseInt(now))&& isPrime(Integer.parseInt(now))){
            counter.add(Integer.parseInt(now));
        } 
        
        
        for(int i = 0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(now + numbers.charAt(i),numbers,visited,counter);
                visited[i] = false;
            }
        }
        
        return counter.size();
    }
    
    private boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}