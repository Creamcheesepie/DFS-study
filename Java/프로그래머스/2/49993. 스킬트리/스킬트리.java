import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for(char c : skill.toCharArray()) set.add(c);
        
        
        for(String skill_tree : skill_trees){
            int head = 0;
            boolean checker = true;
            for(int i = 0; i<skill_tree.length(); i++){
                char userSkill = skill_tree.charAt(i);
                if(set.contains(userSkill)){
                    if(skill.charAt(head) != userSkill){
                        checker = false;
                        break;
                    } else {
                        head++;
                    }
                }
                
            }
            if(checker) answer++;
        }
        
        
        return answer;
    }
}