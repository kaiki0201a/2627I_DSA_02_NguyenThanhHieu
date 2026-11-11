package BT_TH;

import java.util.ArrayList;
import java.util.List;

/*
- Ý tưởng: Dùng thêm mảng để lưu các số đã sử
- Luồng: Chọn - Đệ quy hoặc tiếp tục - Về lại vị trí và thử tiếp
 */

public class LC_46_Permutations {
    public void addRes(List<List<Integer>> res, List<Integer> subRes){
        List<Integer> ano = new ArrayList<>();

        for (int i : subRes)
            ano.add(i);

        res.add(ano);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        List<Boolean> uCheck = new ArrayList<>();

        for (int i: nums)
            uCheck.add(false);

        per(nums, res, subres, uCheck);

        return res;
    }

    public void per(int[] nums, List<List<Integer>> res, List<Integer> subsets, List<Boolean> uCheck) {
        for (int i = 0; i < nums.length; i++) {
            if (uCheck.get(i) == false) {
                subsets.add(nums[i]);
                uCheck.set(i, true);

                if (subsets.size() == nums.length) {
                    addRes(res, subsets);
                } else {
                    per(nums, res, subsets, uCheck);
                }

                uCheck.set(i, false);
                subsets.remove(subsets.size() - 1);
            }
        }
    }
}
