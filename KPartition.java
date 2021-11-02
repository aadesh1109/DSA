import java.util.Stack;

public class KPartition {
    public static void main(String[] args) {
        String exp = "{{";
        System.out.println(balParenthesis(exp));
    }

    private static boolean balParenthesis(String s) {
        if (s.length()%2!=0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char curr = s.charAt(i);
            if (curr=='[' || curr=='{' || curr=='(')
                stack.push(curr);
            else
            {
                if (stack.isEmpty())
                    return false;

                if ((curr==']' && stack.peek()!='[') || (curr=='}' && stack.peek()!='{') || (curr==')' && stack.peek()!='('))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
