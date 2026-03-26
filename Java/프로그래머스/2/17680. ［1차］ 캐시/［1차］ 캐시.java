import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> deque = new ArrayDeque<>();
        if(cacheSize == 0) return cities.length * 5;
        
        for(String city : cities){
            city = city.toLowerCase();
            if(deque.removeFirstOccurrence(city)){
                answer++;
                deque.addFirst(city);
            } else {
                if(deque.size() >= cacheSize){
                    deque.removeLast(); 
                }
                deque.addFirst(city);
                answer+= 5;
            }
        }
        
        return answer;
    }
}