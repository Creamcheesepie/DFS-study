class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1; // 마지막 위치
        int coverage = (w * 2) + 1;
        
        // 음영지역의 길이를 구해서 w 만큼 나누면 설치해야할 기지국 수가 나온다.
        for(int station : stations){
            int right = station - w;
            int blank = right - left;
            
            if(blank > 0) {
                answer += blank / coverage;
                if(blank % coverage > 0) answer++;
            }
            left = station + w + 1;
        }
        
        // 마지막 커버리지가 전체를 커버하지 못할 때
        if(left <= n){
            int blank = n - left + 1;
            answer += blank / coverage; 
            if(blank % coverage > 0) answer++;
        }
        
        return answer;
    }
}