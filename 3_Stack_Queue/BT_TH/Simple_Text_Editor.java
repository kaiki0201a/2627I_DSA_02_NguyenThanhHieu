

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Simple_Text_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<String> S = new Stack<>();
        Stack<Integer> length = new Stack<>();  // Độ dài chuỗi thêm(>0) hoặc xoá(<0)
        Stack<String> his = new Stack<>();  // Lưu lại giá trị vừa xoá

        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            if (type == 1){
                String W = st.nextToken();
                length.push(W.length());
                for (int j = 0; j < W.length(); j++){
                    S.push(String.valueOf(W.charAt(j)));
                }
            } else if (type == 2){
                int k = Integer.parseInt(st.nextToken());
                for (int j = 0; j < k; j ++){
                    String popp = S.pop();
                    his.push(popp);
                }
                length.push(-k);
            } else if (type == 3){
                int k = Integer.parseInt(st.nextToken());
                Object[] arr = S.toArray();
                System.out.println(arr[k-1]);
            } else {
                int last = length.pop();
                if (last >= 0){
                    for (int j = 0; j < last; j++){
                        S.pop();
                    }
                } else {
                    for (int j = 0; j < -last; j++){
                        S.push(his.pop());
                    }
                }
            }
        }
    }
}