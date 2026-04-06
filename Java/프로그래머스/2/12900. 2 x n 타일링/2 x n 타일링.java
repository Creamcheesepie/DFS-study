class Solution {
    public int solution(int n) {
        if(n < 3) return n;
        
        int a = 1;
        int b = 2;
        int answer = 0;
        for(int i = 3; i<=n; i++){
            answer = (a + b) % 1000000007;
            a = b;
            b = answer;
        }
        
        return answer;
    }
}