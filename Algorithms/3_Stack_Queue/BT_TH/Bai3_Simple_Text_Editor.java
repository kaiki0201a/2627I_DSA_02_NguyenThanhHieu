import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bai3_Simple_Text_Editor {

    // Lớp lưu thông tin để Undo
    static class Action {
        int type;       // 1: append, 2: delete
        String data;    // nếu Bai3_Simple_Text_Editorlà delete thì lưu lại chuỗi bị xóa
        int length;     // nếu là append thì lưu độ dài chuỗi đã thêm

        // Dành cho Undo thao tác Append (Type 1)
        Action(int type, int length) {
            this.type = type;
            this.length = length;
        }

        // Dành cho Undo thao tác Delete (Type 2)
        Action(int type, String data) {
            this.type = type;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int q = Integer.parseInt(line.trim());

        StringBuilder s = new StringBuilder();
        Stack<Action> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1: {
                    // Thêm chuỗi W vào cuối S
                    String w = st.nextToken();
                    s.append(w);
                    history.push(new Action(1, w.length()));
                    break;
                }
                case 2: {
                    // Xóa k ký tự cuối cùng của S
                    int k = Integer.parseInt(st.nextToken());
                    int startIdx = s.length() - k;
                    // Lưu lại chuỗi bị xóa để Undo
                    String deletedPart = s.substring(startIdx);
                    s.delete(startIdx, s.length());
                    history.push(new Action(2, deletedPart));
                    break;
                }
                case 3: {
                    // In ký tự thứ k (1-indexed)
                    int k = Integer.parseInt(st.nextToken());
                    System.out.println(s.charAt(k - 1));
                    break;
                }
                case 4: {
                    // Undo thao tác gần nhất
                    if (!history.isEmpty()) {
                        Action lastAction = history.pop();
                        if (lastAction.type == 1) {
                            // Đảo ngược của Append: Xóa lastAction.length ký tự cuối
                            int startIdx = s.length() - lastAction.length;
                            s.delete(startIdx, s.length());
                        } else if (lastAction.type == 2) {
                            // Đảo ngược của Delete: Thêm lại chuỗi đã xóa
                            s.append(lastAction.data);
                        }
                    }
                    break;
                }
            }
        }
    }
}