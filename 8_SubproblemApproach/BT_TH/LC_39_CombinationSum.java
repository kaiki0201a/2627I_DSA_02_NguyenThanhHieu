package BT_TH;

import java.util.ArrayList;
import java.util.List;

public class LC_39_CombinationSum {
    public void addRes(List<List<Integer>> res, List<Integer> subRes){
        List<Integer> ano = new ArrayList<>();

        for (int i : subRes)
            ano.add(i);

        res.add(ano);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();

        cookie(res, subRes, candidates, target, 0, 0);
        return res;
    }

    public void cookie(List<List<Integer>> res, List<Integer> subRes,int[] candidates, int target, int sum, int start){
        for (int i = start; i < candidates.length; i++){
            if (sum + candidates[i] <= target){
                subRes.add(candidates[i]);
                sum += candidates[i];

                if (sum == target){
                    addRes(res, subRes);
                } else {
                    cookie(res, subRes, candidates, target, sum, i);
                }

                subRes.remove(subRes.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
