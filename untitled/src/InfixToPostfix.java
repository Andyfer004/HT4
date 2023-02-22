import java.util.Stack;

public class InfixToPostfix {/**
     * @param args the command line arguments
     */

    public static String InfixToPostfix(String expression) { /**
         * @param args the command line arguments
         */

        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        char[] chars = expression.toCharArray();

       /**
         * @param args the command line arguments
         */
        for (char c : chars) {
            // Ignorar espacios en blanco
            if (c == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }

            else if (c == '(') {
                operatorStack.push(c);
            }
            /**
             * @param args the command line arguments
             */
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    return "Expresión inválida: paréntesis desbalanceados";
                } else {
                    operatorStack.pop();
                }
            }
            /**
             * @param args the command line arguments
             */
            else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        /**
         * @param args the command line arguments
         */
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
