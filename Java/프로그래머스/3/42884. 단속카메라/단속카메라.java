import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 그리디는 일단 정렬을 하고 보자
        // 자동차가 나가는 지점을 기준으로 정렬하여 나가는 차량 오름차순으로 정렬한다. 
        Arrays.sort(routes,
                    (r1,r2) -> {return r1[1] - r2[1];}
                   );
        int answer = 1;
        // 처음 들어온 차량이 제일 빨리 나간다 -> 따라서 이 지점을 첫 카메라 포인트로 잡음
        int lastCam = routes[0][1];
        for(int[] route : routes){
            int in = route[0];
            int out = route[1];
            // 만약 설치된 카메라보다 먼 지점에서 들어오는 차량이 있으면 해당 차량의 탈출 지점을 카메라 설치 포인트로 설정.
            if(in > lastCam){
                answer++;
                lastCam = out;
            }
        }
        
        
        return answer;
    }
}