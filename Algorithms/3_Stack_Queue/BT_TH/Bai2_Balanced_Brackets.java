package BT_TH;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Bai2_Balanced_Brackets {
    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        int length = s.length();

        for (int i = 0; i < length; i++){
            Character type = s.charAt(i);
            if (type.equals('(') || type.equals('{') || type.equals('['))
                st.push(type);
            else if (st.peek().equals('(') && type.equals(')'))
                st.pop();
            else if (st.peek().equals('{') && type.equals('}'))
                st.pop();
            else if (st.peek().equals('[') && type.equals(']'))
                st.pop();
            else
                return "NO";
        }
        if (st.isEmpty())
            return "YES";
        else
            return "NO";
    }

}


