class Solution {
    boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        int answer = dfs(numbers,0,target,0);
        return answer;
    }
    
    private int dfs(int[] numbers, int idx, int target, int n){
        int max = 0;
        if(idx == numbers.length && n == target ) return 1;
        else if(idx == numbers.length) return 0;
        
        max += dfs(numbers, idx+1, target, n + numbers[idx]);
        max += dfs(numbers, idx+1, target, n - numbers[idx]);
        
        return max;
    }
}