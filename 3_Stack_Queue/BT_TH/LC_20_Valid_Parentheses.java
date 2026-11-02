// Kiem tra ngoac hop le vi du (){}
// Y tuong: ngoac mo -> push; ngoac dong: kiem tra va pop

public class LC_20_Valid_Parentheses {
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' || st.isEmpty()){
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')' & st.peek() == '('){
                st.pop();
            } else if (s.charAt(i) == '}' & st.peek() == '{') {
                st.pop();
            } else if (s.charAt(i) == ']' & st.peek() == '[') {
                st.pop();
            } else return false;
        }

        if (st.isEmpty()){
            return true;
        } else return false;
    }
}
