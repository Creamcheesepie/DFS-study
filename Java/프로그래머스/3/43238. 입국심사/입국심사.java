import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = times[0];
        long max = times[times.length - 1] * (long)n;

        
        while(min <= max){
            long mid = (min + max) / 2;
            long total = 0;
            // 중간 값으로 해서 태울 수 있는 사람의 수
            for(int time : times){
                total += mid / time;
            }
            
            // 만약 total이 n보다 적으면 중간값으로 사람을 다 처리했다는 뜻이므로 min을 재설정
            if(total < n) min = mid + 1;
            else { // 아니라면 사람을 처리하고도 남았다는 뜻이므로 max를 재설정
                answer = mid;
                max = mid - 1;
            }
        }
        
        
        return answer;
    }
}