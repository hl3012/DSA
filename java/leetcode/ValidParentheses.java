import java.util.*;
public class ValidParentheses {
    public boolean isValid(String st) {
        Stack<Character> s=new Stack<>();
        for (char c: st.toCharArray()) {
            if (c=='('||c=='{'||c=='[') {
                s.push(c);
            } else {
                if (s.isEmpty()) return false;
                char top=s.peek();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                        return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
