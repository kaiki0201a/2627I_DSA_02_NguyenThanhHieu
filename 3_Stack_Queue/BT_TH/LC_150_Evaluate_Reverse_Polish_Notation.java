// Tinh bieu thuc balan nguoc
// input: tokens = ["2","1","+","3","*"]

import java.util.Stack;

public class LC_150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens){
        Stack<Integer> st = new Stack<>();
        for (String i: tokens){
            if (i.matches("-?\\d+")){
                st.push(Integer.parseInt(i));
            } else{
                int st2 = st.pop(); int st1 = st.pop();

                if (i.equals("+")){
                    st.push(st1 + st2);
                } else if (i.equals("-")){
                    st.push(st1 - st2);
                } else if (i.equals("*")){
                    st.push(st1 * st2);
                } else {
                    st.push(st1 / st2);
                }
            }
        }
        return st.peek();
    }
}
