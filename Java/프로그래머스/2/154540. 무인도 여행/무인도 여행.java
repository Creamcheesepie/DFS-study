import java.util.*;

class Solution {
    int maxH = 0;
    int maxW = 0;
    boolean[][] visited;
    int[] dirH = new int[] {1,-1,0,0};
    int[] dirW = new int[] {0,0,1,-1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        maxH = maps.length;
        maxW = maps[0].length();
        List<Integer> list = new ArrayList<>();
        visited = new boolean[maxH][maxW];
        for(int h = 0; h<maxH; h++){
            for(int w = 0; w<maxW; w++){
                if(maps[h].charAt(w) != 'X' && !visited[h][w]) list.add(dfs(maps,h,w,0));
            }
        }
    
        list.sort((i1, i2) -> i1 - i2);
        if(list.size() == 0) return new int[] {-1};
        else return list.stream().mapToInt(i -> i).toArray();
    }
    
    private int dfs(String[] maps, int h, int w, int food){
        visited[h][w] = true;
        food = maps[h].charAt(w) - '0';
        
        for(int i=0 ; i<4; i++){
            int nh = h + dirH[i];
            int nw = w + dirW[i];
            
            if(
                nh > -1 && nh < maxH &&
                nw > -1 && nw < maxW &&
                maps[nh].charAt(nw) != 'X' &&
                !visited[nh][nw]
            ){
                food += dfs(maps, nh, nw, food);
            }
        }
        return food;
    }
}