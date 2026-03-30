import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int w = 0;
        int h = 0;
        
        for(int i = 0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            int nw = w;
            int nh = h;
            
            if(c == 'U') nh++;
            if(c == 'D') nh--;
            if(c == 'R') nw++;
            if(c == 'L') nw--;
            
            if(Math.abs(nh) > 5 || Math.abs(nw) >5) continue;
            
            int path = (w + 5) << 12 | (h + 5) << 8 | (nw + 5) << 4 | (nh+5);
            int rpath = (nw + 5) << 12 | (nh + 5) << 8 | (w + 5) << 4 | (h+5);
            if(!set.contains(path)) {
                set.add(path);
                set.add(rpath);
                answer++;
            }
            h = nh;
            w = nw;
            
        }
        
        
        return answer;
    }
}