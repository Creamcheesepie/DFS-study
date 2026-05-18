import java.util.*;
/*
    펠린드롬 확인.
    문자열 길이가 2500이니까 O(n^2) 라도 그렇게 오래 걸리진 않음
    다만 그래도 펠린드롬을 좀 더 효율적으로 알 수 있는 방법이 있으면 좋겠는데...
    가운데 문자가 1개인 경우 / 2개인 경우
    dp를 써?
    110110101
*/
class Solution{
    public int solution(String s){
        int answer = 0;
        int n = s.length();
        
        for(int i = 0; i<n; i++){
            int odd = isPalindrome(s,i,i);
            int even = isPalindrome(s,i,i+1);
            
            int max = Math.max(odd, even);
            answer = Math.max(max,answer);
        }

        return answer;
    }
    
    private int isPalindrome(String str,int left, int right){
        int len = str.length();
        while(left > -1 && right < len && str.charAt(left) == str.charAt(right)){
            left --;
            right ++;
        }
        return right - left -1;
    }
}