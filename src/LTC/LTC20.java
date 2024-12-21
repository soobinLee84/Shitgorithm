package LTC;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 */
public class LTC20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');  // push값을 닫는 괄호로!
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Deque<Character> stack = new ArrayDeque();

        char val = ' ';
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')') {
                val = stack.pop();
                if (val != '(') {
                    return false;
                }
            } else if (c == '}') {
                val = stack.pop();
                if (val != '{') {
                    return false;
                }
            } else if (c == ']') {
                val = stack.pop();
                if (val != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
