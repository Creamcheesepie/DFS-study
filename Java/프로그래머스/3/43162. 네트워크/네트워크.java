class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(!visited[i])answer++;
            dfs(computers,i);
        }
        
        System.out.println(answer);
        
        return answer;
    }
    
    //연결된 모든 컴퓨터를 체크만 하기!
    private void dfs(int[][] computers,int n){
        int[] current = computers[n];
        for(int i = 0; i<current.length; i++){
            if(!visited[i] && current[i] == 1){
                visited[i] = true;
                dfs(computers,i);
            }
        }
    }
}