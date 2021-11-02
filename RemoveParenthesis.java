import java.util.*;
public class RemoveParenthesis {
    public static void main(String[] args) {
        String input = "a-(b-c-(d+e))-f";
        // input = "a-(b+c)-(f+(d-e))";
        Stack<Character> stack = new Stack<>();
        String res = process(input.toCharArray(), stack);
        System.out.println(res);
    }

    private static String process(char[] input, Stack<Character> stack) {
        StringBuilder res = new StringBuilder();
        res.append(input[0]);
        for(int i=1; i<input.length; i++){
            char curr = input[i];

            if(curr == ')'){
                stack.pop();
            }else if(curr == '('){
                char prev = input[i-1];
                if(stack.isEmpty()){
                    stack.push(prev);
                }else{
                    if(stack.peek() == '-'){
                        if(prev == '-'){
                            stack.push('+');
                        }else if(prev == '+'){
                            stack.push('-');
                        }
                    }else{
                        stack.push(prev);
                    }
                }

            }else{
                if(!stack.isEmpty()){
                    char top = stack.peek();
                    if(top == '-'){
                        if(curr == '-'){
                            curr = '+';
                        }else if(curr == '+'){
                            curr = '-';
                        }
                    }
                }
                res.append(curr);
            }
        }

        return res.toString();
    }
}