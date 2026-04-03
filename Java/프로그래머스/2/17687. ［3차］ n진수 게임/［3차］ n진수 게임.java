class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int numb = 0;
        // 문자열의 길이가 t*m보다 길 때 까지 n진법 수를 더해나가기
        while(sb.length() < t * m) sb.append(Integer.toString(numb++,n));
        
        String fullNumbers = sb.toString().toUpperCase();
        
        sb = new StringBuilder();
        // p-1 번이 내가 부를 수의 인덱스 + (i * m) 은 라운드
        for(int i = 0; i< t; i++){
            sb.append(fullNumbers.charAt((p-1) + (i * m)));
        }
        
        return sb.toString();
    }
}