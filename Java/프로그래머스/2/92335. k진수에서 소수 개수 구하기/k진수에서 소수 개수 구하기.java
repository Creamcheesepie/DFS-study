class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kDecimal = Integer.toString(n,k);
        String[] bits = kDecimal.split("0");
        
        for(String bit : bits){
            if(bit.isBlank()) continue;
            if(isPrime(Long.parseLong(bit))) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long n){
        if(n == 1) return false;
        for(long i = 2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}