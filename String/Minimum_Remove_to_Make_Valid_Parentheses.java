package String;

import java.util.ArrayList;
import java.util.List;

class Solution_Minimum_Remove_to_Make_Valid_Parentheses {
    public String minRemoveToMakeValid(String s) {
        List<Integer> stack = new ArrayList<>();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ')') {
                if (stack.size() > 0 && s.charAt(stack.getLast()) == '(') {
                    stack.removeLast();
                } else {
                    stack.addLast(i);
                }
            }
            if (temp == '(') {
                stack.addLast(i);
            }
        }

        while (!stack.isEmpty()) {
            ans.deleteCharAt(stack.getLast());
            stack.removeLast();
        }
        return ans.toString();
    }
}

public class Minimum_Remove_to_Make_Valid_Parentheses {
    public static void main(String[] args) {
        String result = new Solution_Minimum_Remove_to_Make_Valid_Parentheses().minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(result);
    }
}
