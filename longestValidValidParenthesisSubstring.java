// STACK problem
import java.util.Stack;

public class longestValidValidParenthesisSubstring {
    public static void main(String[] args) {
        String s = ")(()()))(()())()())()(";
        int maxLen = longestValidParentheses(s);
        System.out.println(maxLen);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.isEmpty() || s.charAt(stack.peek()) == ')')
                    stack.push(i);
                else
                    stack.pop();
            }
        }
//        System.out.println(stack);
        int maxLength = 0;
        int toBeSubtractedFrom = s.length();
        while (!stack.isEmpty()) {
            int popped = stack.pop();
//            System.out.println(toBeSubtractedFrom-popped-1);
            maxLength = Math.max(maxLength, toBeSubtractedFrom - popped - 1);
            toBeSubtractedFrom = popped;
        }
//        System.out.println(toBeSubtractedFrom-(-1)-1);
        return Math.max(maxLength, toBeSubtractedFrom - (-1) - 1);
    }
}
