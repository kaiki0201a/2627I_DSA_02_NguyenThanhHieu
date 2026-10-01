import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Queue_Using_Two_Stacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            // enqueue
            if (type.equals("1")){
                int x = Integer.parseInt(st.nextToken()) ;
                stack1.push(x);
            }
            // dequeue
            else if (type.equals("2")) {
                if (!stack2.isEmpty()){
                    stack2.pop();
                } else {
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    stack2.pop();
                }
            }
            // peek
            else {
                int p = 0;
                if (!stack2.isEmpty()) {
                    p = stack2.pop();
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    p = stack2.pop();
                }
                System.out.println(p);
                stack2.push(p);
            }
            }
        }
}
