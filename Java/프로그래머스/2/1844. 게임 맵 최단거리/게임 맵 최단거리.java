import java.util.*;

class Solution {
    int[] dx = new int[] {1,-1,0,0};
    int[] dy = new int[] {0,0,1,-1};
    boolean[][] visited;
    
    // bfs 쓰는 문제~
    public int solution(int[][] maps) {
        int answer = -1;
        int maxX = maps.length;
        int maxY = maps[0].length;
        
        visited = new boolean[maxX][maxY];
        
        Deque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            if(x == maxX -1 && y  == maxY - 1){
                answer = distance;
                break;
            }
            
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx > -1 && nx <maxX && ny > -1 && ny < maxY && !visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny,distance+1});
                }
            }
        }
        
        
        return answer;
    }
}