class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayGcd(arrayA);
        int gcdB = arrayGcd(arrayB);
        
        int resultA = gcdA;
        int resultB = gcdB;
        
        // 최대 공약수 기반으로 반대 배열이 나누어지는지 확인
        for(int a : arrayA){
            if(a % gcdB == 0) {
                resultB = 0;
                break;
            }
        }
        
        for(int b : arrayB){
            if(b % gcdA == 0){
                resultA = 0;
                break;
            }
        }
        
        // 둘 중 큰 수 반환
        return Math.max(resultA,resultB);
    }
    
    // 유클리드 호제법 이용해 최대 공약수 가져오기
    private int gcd(int a, int b){
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }
    
    // 각 배열의 최대공약수 찾기
    private int arrayGcd(int[] arr){
        int res = arr[0];
        if(arr.length == 1) return res;
        for(int i = 1; i<arr.length; i++){
            res = gcd(res,arr[i]);
        }
        return res;
    }
    
}