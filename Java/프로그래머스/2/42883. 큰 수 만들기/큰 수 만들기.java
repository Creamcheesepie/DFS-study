class Solution {
    public String solution(String number, int k) {
        int numberLen = number.length();
        int answerLen = numberLen - k;
        char[] answer = new char[answerLen];
        int top = 0;
        
        for(int i = 0; i< numberLen; i++){
            char current = number.charAt(i);
            
            while(top > 0 && answer[top - 1] < current && k > 0) {
                top--;
                k--;
            }
            
            
            if(top < answerLen){
                answer[top++] = current;
            } else {
                k--;
            }
        }
        
        return new String(answer);
    }
}