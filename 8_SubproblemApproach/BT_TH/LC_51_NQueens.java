package BT_TH;

import java.util.ArrayList;
import java.util.List;

public class LC_51_NQueens {

    public void addRes(List<List<String>> res, List<String> subRes){
        List<String> ano = new ArrayList<>();

        for (String i : subRes)
            ano.add(i);

        res.add(ano);
    }

    public void mark(List<List<Boolean>> uCheck, int m, int n){
        for (int i = m; i < uCheck.size(); i++){
            for (int j = 0; j < uCheck.size(); j++){
                if (i == n || j == n ||  i + j == m + n || i - j == m  -n){
                    uCheck.get(i).set(j, true);
                }
            }
        }
    }

    public void unmark(List<List<Boolean>> uCheck, int m, int n){
        for (int i = m; i < uCheck.size(); i++){
            for (int j = 0; j < uCheck.size(); j++){
                if (i == m || j == n ||  i + j == m + n || i - j == m - n){
                    uCheck.get(i).set(j, false);
                }
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> subRes = new ArrayList<>();
        List<List<Boolean>> uCheck = new ArrayList<>();
        List<Boolean> ano = new ArrayList<>();

        for (int i = 0; i < n; i++){
            ano = new ArrayList<>();
            for (int j = 0; j < n; j++){
                ano.add(false);
            }
            uCheck.add(ano);
        }
        King(res, subRes, uCheck, n);

        return res;
    }

    public void King(List<List<String>> res, List<String> subRes, List<List<Boolean>> uCheck, int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){

                // Tai day co chon duoc hay khong
                if (uCheck.get(i).get(j) == false){
                    subRes.add("Q");
                    mark(uCheck, i, j);

                    if (subRes.size() == n){
                        addRes(res, subRes);
                    } else {
                        King(res, subRes, uCheck, n);
                    }

                    unmark(uCheck, i, j);
                    subRes.remove(subRes.size() - 1);
                } else {
                    subRes.add(".");
                }
            }
        }
    }

}
