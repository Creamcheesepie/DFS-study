import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 인접 리스트 선언 후 각 노드 개수만큼 리스트 삽입
        List<List<Integer>> adList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adList.add(new ArrayList<Integer>());
        }
        
        // 인접 리스트에 각 노드를 추가
        for(int i = 0; i<edge.length; i++){
            int[] e = edge[i];
            adList.get(e[0]).add(e[1]);
            adList.get(e[1]).add(e[0]);
        }
        
        // 노드는 1~n까지므로 node의 최대 거리를 저장할 배열과 방문 여부를 저장할 배열의 길이는 n+1
        int[] dist = new int[n+1]; 
        boolean[] visited = new boolean[n+1];
        // bfs에 쓸 큐
        Queue<Integer> q = new ArrayDeque<>();
        //초기값 설정
        q.offer(1);
        visited[1] = true;
        int max = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : adList.get(cur)){
                if(!visited[next]){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                    max = Math.max(max,dist[next]);
                    visited[next] = true;
                }
            }
        }
        
        
        for(int d : dist) if(max == d) answer++;
        
        return answer;
    }
    
    
    
}