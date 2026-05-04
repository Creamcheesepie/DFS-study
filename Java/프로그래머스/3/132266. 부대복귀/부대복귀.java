import java.util.*;


class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int[] road : roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        
        int[] distances = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distances, -1);
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        deque.offer(new int[] {destination,0});
        visited[destination] = true;
        
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            distances[current[0]] = current[1];
            List<Integer> nexts = list.get(current[0]);
            for(int next : nexts){
                if(!visited[next]) {
                    visited[next] = true;
                    deque.offer(new int[] {next,current[1] +1});
                }
            }
            
        }
        
        
        
        int[] answer = new int[sources.length];
        for(int i = 0; i<sources.length; i++){
            answer[i] = distances[sources[i]];
        }
        return answer;
    }
}