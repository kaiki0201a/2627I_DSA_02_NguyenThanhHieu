import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_224_Basic_Calculator {
    public static long evalRPN(List<String> tokens) {
        Stack<Long> st = new Stack<>();
        for (String i : tokens) {
            if (i.matches("-?\\d+")) {
                st.push(Long.parseLong(i));
            } else {
                long st2 = st.pop();
                long st1 = st.pop();

                if (i.equals("+")) {
                    st.push(st1 + st2);
                } else if (i.equals("-")) {
                    st.push(st1 - st2);
                } else if (i.equals("*")) {
                    st.push(st1 * st2);
                } else {
                    st.push(st1 / st2);
                }
            }
        }
        return st.peek();
    }
    public static int calculate(String s) {
        s = s.trim();

        List<String> listt = new ArrayList<>();

        Map<Character, Integer> mapp = new HashMap<>();
        mapp.put('-', 1);
        mapp.put('+', 1);
        mapp.put('*', 2);
        mapp.put('/', 2);
        mapp.put('^', 3);

        Stack<Character> st = new Stack<>();
        int last = 0;

        for (int j = 0; j < s.length(); j++){
            Character cha = s.charAt(j);

            if (cha == ' '){
                last = j-1;
            }
            while (j < s.length() && s.charAt(j) == ' '){
                j += 1;
                cha = s.charAt(j);
            }

            if (cha.equals('(')){
                st.push('(');
            } else if (cha.equals(')')){
                while (st.peek() != '('){
                    listt.add(String.valueOf(st.pop()));
                }
                st.pop();
            } else if (mapp.containsKey(cha)){

                if  ((cha == '-' && s.charAt(last) == '(') || (listt.size() == 0 && cha == '-')) {
                    listt.add("0");
                }

                while (!st.isEmpty() && mapp.getOrDefault(st.peek(), -1) >= mapp.get(cha) && !cha.equals('^')){
                    listt.add(String.valueOf(st.pop()));
                }

                st.push(cha);
            } else {
                int k = j;
                while (k < s.length() && Character.isDigit(s.charAt(k)))
                    k++;
                listt.add(s.substring(j, k));
                j = k - 1;
            }
            last = j;
        }
        while (!st.isEmpty()) listt.add(String.valueOf(st.pop()));

        System.out.println(listt);
        return (int) evalRPN(listt);
    }

    static void main() {
        String s = "-21";
        System.out.println(calculate(s));
    }

}
