class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return count;
    }
    
    private void dfs(int[] numbers, int target,int i,int total){
        if(i == numbers.length){
            if(total == target) count++;
            return;
        }
        
        dfs(numbers,target,i+1,total+numbers[i]);
        dfs(numbers,target,i+1,total-numbers[i]);
    }
}