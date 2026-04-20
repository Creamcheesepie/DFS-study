class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int time = 0;
        int totalServer = 0;
        int[] returnTime = new int[players.length + k];

        for(int p : players){
            totalServer -= returnTime[time];
            int cap = m + (m * totalServer);
            if(cap <= p){
                int need = (p - cap + 1) / m;
                if((p - cap +1) % m > 0) need++;
                answer += need;
                totalServer += need;
                returnTime[time + k] = need;
            }
            time++;
        }
        
        
        return answer;
    }
}