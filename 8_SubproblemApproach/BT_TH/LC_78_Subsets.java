package BT_TH;

import java.util.ArrayList;
import java.util.List;

/*
Nguyên tắc: Khi lời gọi hàm kết thúc thì subset phải y như lúc ban đầu để tiếp tục
 */

public class LC_78_Subsets {
    public void addRes(List<List<Integer>> res, List<Integer> subRes){
        List<Integer> ano = new ArrayList<>();

        for (int i : subRes)
            ano.add(i);

        res.add(ano);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i <= nums.length ; i++){
            sqrt(nums, i, res, new ArrayList<>(), 0);
        }
        return res;
    }

    public void sqrt(int[] nums, int length, List<List<Integer>> res, List<Integer> another, int n){
        for (int i = n; i < nums.length; i++){
            // Chọn phần tử kế tiếp
            another.add(nums[i]);

            // Dừng khi đạt độ dài
            if (another.size() == length)
                addRes(res, another);
            else // Đệ quy tiếp tục
                sqrt(nums, length, res, another, i + 1);

            // Trở về trạng thái ban đầu
            another.remove(another.size() - 1);

        }
    }
}

