package BT_TH;

import java.util.ArrayList;
import java.util.List;

public class LC_51_NQueens {
    public void addRes(List<List<String>> res, List<String> subRes){
        List<String> ano = new ArrayList<>();

        for (String st:subRes){
            ano.add(st);
        }

        res.add(ano);
    }

    public StringBuilder newS(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(".");
        }
        return sb;
    }

    public void mark(int i, int j, boolean[] cotCheck, boolean[] d1check, boolean[] d2check, int n){
        cotCheck[j] = true;
        d1check[i+j] = true;
        d2check[i-j + n] = true;
    }
    public void unmark(int i, int j, boolean[] cotCheck, boolean[] d1check, boolean[] d2check, int n){
        cotCheck[j] = false;
        d1check[i+j] = false;
        d2check[i-j + n] = false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> subRes = new ArrayList<>();
        boolean[] cotCheck = new boolean[n];
        boolean[] d1Check = new boolean[2*n + 1];
        boolean[] d2Check = new boolean[2*n];

        King(res, subRes, n, cotCheck, d1Check, d2Check, 0, newS(n));

        return res;
    }

    public void King(List<List<String>> res, List<String> subRes, int n, boolean[] cotCheck, boolean[] d1check, boolean[] d2check, int hang, StringBuilder s){
        int i = hang;    // Duyet theo hang de tim vi tri
            for (int j = 0; j < n; j++){
                // Kiem tra tai vi tri nay co dat duoc khong,
                if (cotCheck[j] == false && d1check[i+j] == false && d2check[i-j+n] == false) {
                    // Neu co, dat nhung phan tu phia sau la dau .
                    s.replace(j, j + 1, "Q");
                    mark(i, j, cotCheck, d1check, d2check, n);

                    subRes.add(s.toString());

                    // Kiem tra da xong hang cuoi chua, neu roi thi them vao res
                    if (subRes.size() == n){
                        addRes(res, subRes);
                    } else { // Neu chua thi de quy tiep tuc
                        King(res, subRes, n, cotCheck, d1check, d2check, hang + 1, newS(n));
                    }

                    s.replace(j, j + 1, ".");
                    unmark(i, j, cotCheck, d1check, d2check, n);
                    subRes.remove(subRes.size() - 1);
                }
            }
        }
}
