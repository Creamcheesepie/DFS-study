import java.util.*;

class Solution {
    public int solution(String[] maps) {
        // 우와아아앙 재미있는 BFS 시간이에요~
        int[] hDir = new int[] {1,-1,0,0};
        int[] wDir = new int[] {0,0,1,-1};
        int hMax = maps.length;
        int wMax = maps[0].length();
        boolean lever = false;
        boolean goal = false;
        boolean[][] visited = new boolean[hMax][wMax];
        Deque<int[]> deque = new ArrayDeque<>();
        
        for(int h = 0; h< maps.length; h++){
            for(int w = 0; w< maps[h].length(); w++){
                if(maps[h].charAt(w) == 'S'){
                    deque.offer(new int[] {h,w,0});
                    visited[h][w] = true;
                }
            }
        }
        
        while(!deque.isEmpty()){
            int[] current = deque.poll();
            int h = current[0];
            int w = current[1];
            
            if(lever && maps[h].charAt(w) == 'E') return current[2];
            if(!lever && maps[h].charAt(w) == 'L'){
                lever = true;
                deque = new ArrayDeque<>();
                visited = new boolean[hMax][wMax];
            }
            
            for(int i = 0; i<4; i++){
                int nh = h + hDir[i];
                int nw = w + wDir[i];
                
                if(nh >= 0 &&
                   nw >= 0 &&
                   nh < hMax &&
                   nw < wMax &&
                   !visited[nh][nw] &&
                   maps[nh].charAt(nw) != 'X'
                  ){
                    visited[nh][nw] = true;
                    deque.offer(new int[] {nh,nw,current[2]+1});
                }
            }
        }
        return -1;
    }
}