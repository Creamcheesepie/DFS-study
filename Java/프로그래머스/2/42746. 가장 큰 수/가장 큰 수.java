import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        int n = numbers.length;
        String[] strArr = new String[n];
        for(int i = 0; i<n; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strArr,(s1 ,s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });
        
        if(strArr[0].equals("0")) return "0";
        for(String str : strArr){
            sb.append(str);
        }
        
        return sb.toString();
    }
}