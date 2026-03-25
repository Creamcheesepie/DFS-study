class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons,0,0,k);
        return answer;
    }
    
    private void dfs(int[][] dungeons,int stage, int level,int stamina){
        answer = Math.max(level, answer);
        for(int i = 0; i<dungeons.length; i++){
            int[] dungeon = dungeons[i];
            int require = dungeon[0];
            if(stamina >= require && !visited[i]){
                visited[i] =true;
                dfs(dungeons,i,level+1,stamina - dungeon[1]);
                visited[i] = false;
            }
        }
    }
}