class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int curr = storey %10;
            storey /= 10;
            
            if(curr > 5){
                answer+= 10 - curr;
                storey ++;
            } else if(curr == 5){
                if(storey % 10 > 4){
                    storey++;
                } 
                answer += curr;
            } else {
                answer+= curr;
            }
            
        }
        
        
        return answer;
    }
}