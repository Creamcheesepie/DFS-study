import java.util.*;

class Solution {
    public int solution(String[] board) {
        int hMax = board.length;
        int wMax = board[0].length();
        int[] hDir = new int[] {1,-1,0,0};
        int[] wDir = new int[] {0,0,1,-1};
        boolean[][] visited = new boolean[hMax][wMax];
        Deque<int[]> queue = new ArrayDeque<>();
        
        boolean flag = false;
        for(int h = 0; h<hMax; h++){
            for(int w = 0; w<wMax; w++){
                if(board[h].charAt(w) == 'R'){
                    queue.offer(new int[] {h,w,0});
                    visited[h][w] = true;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int h = current[0];
            int w = current[1];
            int cnt = current[2];
            if(board[h].charAt(w) == 'G') return cnt;
            
            for(int i = 0; i<4; i++){
                int nh = h;
                int nw = w;
                while(true){
                    int th = nh + hDir[i];
                    int tw = nw + wDir[i];
                    if(
                        th < 0 || th >= hMax ||
                        tw < 0 || tw >= wMax ||
                        board[th].charAt(tw) == 'D'
                    ) break;
                    nh = th;
                    nw = tw;
                }
                
                if(!visited[nh][nw]){
                    queue.offer(new int[] {nh,nw,cnt+1});
                    visited[nh][nw] = true;
                }
            }
        }

        return -1;
    }
}