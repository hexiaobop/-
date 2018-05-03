package calculate;

import java.util.ArrayList;
import java.util.Stack;

public class behindExerce {
    public static void main(String[] args) {
        String s = "a+b*c+(d*e+f)*g";
        createExpression(s);// ----> abc*+de*f+g*+
    }
    static void createExpression(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        ArrayList list = new ArrayList();
        for (char a : chars) {
            //如果是数字或者字母
            if (Character.isLetterOrDigit(a)) {
                list.add(a);
            } else if (isLeft(a)) {
                stack.push(a);
            } else if (isRight(a)) {
                while (!isLeft(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && priority(a) <= priority(stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(a);
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    static boolean isAdd(char c) {
        return c == '+' ? true : false;
    }

    static boolean isSubtract(char c) {
        return c == '-' ? true : false;
    }

    static boolean isMult(char c) {
        return c == '*' ? true : false;
    }

    static boolean isDivide(char c) {
        return c == '/' ? true : false;
    }

    static boolean isLeft(char c) {
        return c == '(' ? true : false;
    }

    static boolean isRight(char c) {
        return c == ')' ? true : false;
    }

    static int priority(char c) {
        if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return 0;
    }

}
