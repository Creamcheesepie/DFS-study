import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // 즐거운 BFS 시간~~ 뚜룰뚜루
        Deque<int[]> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(new int[]{x,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int now = current[0];
            int cnt = current[1];
            if(now == y) return cnt;
            
            
            cnt++;
            int[] nexts = new int[]{now + n, now * 2, now * 3};
            for(int next : nexts){
                if(set.contains(next) || next > y ) continue;
                queue.offer(new int[]{next,cnt});
                set.add(next);
            }
        }
        
        
        return -1;
    }
}