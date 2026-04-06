import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> list = new ArrayList<>();
        
        for(String file : files){
            String head = "";
            String number = "";
            String tail = "";
            
            boolean headStart = true;
            boolean numStart = false;
            int left = 0;
            int right = 0;
            while(right <file.length() && !Character.isDigit(file.charAt(right))) right ++;
            head = file.substring(left,right).toLowerCase();
            
            left = right;
            while(right <file.length() && Character.isDigit(file.charAt(right)) && (right - left) < 5) right++;
            number = file.substring(left,right);
            
            list.add(new String[] {head,number,file});
        }
        
        Collections.sort(list,
            (arr1 , arr2) -> {
                int c = arr1[0].compareTo(arr2[0]);
                if(c == 0) c = Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
                return c;
            } 
        );
                
        String[] answer = new String[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i)[2];
        }
        
        return answer;
    }
}