class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        // 그래프 배열 선언
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i<wires.length; i++){
            int[] wire = wires[i];
            // 그래프 배열 채우기
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        for(int i = 0; i<wires.length; i++){
            int[] cut = wires[i];
            
            // 간선 단절
            graph[cut[0]][cut[1]] = 0;
            graph[cut[1]][cut[0]] = 0;
            
            // 단절된 간선 기준으로 dfs 실행
            boolean[] visited = new boolean[n+1];
            int cnt = dfs(graph,1,n,visited);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            // 간선 재연결
            graph[cut[0]][cut[1]] = 1;
            graph[cut[1]][cut[0]] = 1;
        }
        
        return answer;
    }

    private int dfs(int[][] graph,int node,int n,boolean[] visited){
        visited[node] = true;
        int cnt = 1;
        
        // 연결된 간선의 개수만 세기 (전체 노드 개수 - 연결된 간선의 개수로 나머지 연결된 그래프 찾을 수 있음)
        for(int next = 1; next<= n; next++){
            if(!visited[next] && graph[node][next] == 1){
                cnt += dfs(graph, next,n, visited);
            }
        }
        return cnt;
    }
}