class Solution {
    public String solution(String s) {
        String[] bits = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String bit : bits){
            int number = Integer.parseInt(bit);
            max = Math.max(max,number);
            min = Math.min(min,number);
        }
        
        return min + " " + max;
    }
}