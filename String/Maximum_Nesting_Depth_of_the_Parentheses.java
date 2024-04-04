package String;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int maxDepth(String s) {
        List<Character> stack=new LinkedList<>();
        int ans=0;
        for(char i:s.toCharArray()){
            if(i=='('){
                stack.addLast(i);
                ans=Math.max(ans, stack.size());
            }
            if(i==')'){
                stack.removeLast();
            }
        }
        return ans;
    }
}
public class Maximum_Nesting_Depth_of_the_Parentheses {
    
}

