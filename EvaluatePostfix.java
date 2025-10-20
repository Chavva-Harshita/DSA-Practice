import java.util.Stack;

public class EvaluatePostfix {
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // convert char to int
            } 
            
            else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "231*+9-";
        System.out.println("Postfix Evaluation: " + evaluatePostfix(expression));
    }
}
