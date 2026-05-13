import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalWaitTime = 0;
        int currentTime = 0;
        int jobIdx = 0;
        int completedJobs = 0;
        
        Arrays.sort(jobs,(j1,j2) -> j1[0] - j2[0]);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1 , arr2) -> arr1[1] - arr2[1]);
        
        
        while(completedJobs < jobs.length){
            // 현재시간까지 들어온 모든 요청을 큐 삽입
            while(jobIdx< jobs.length && jobs[jobIdx][0] <= currentTime){
                pq.offer(jobs[jobIdx++]);
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[jobIdx][0];
            } else {
                int[] job = pq.poll();
                totalWaitTime += (currentTime - job[0]) + job[1];
                currentTime += job[1];
                completedJobs++;
            }
        }
        
        
        return totalWaitTime / jobs.length;
    }
}