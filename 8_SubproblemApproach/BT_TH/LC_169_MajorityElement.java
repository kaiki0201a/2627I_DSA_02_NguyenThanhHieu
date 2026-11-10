package BT_TH;

public class LC_169_MajorityElement {
    public int majorityElement(int[] nums) {
        return major(nums, 0, nums.length - 1);
    }
    public int major(int[] nums, int l, int r){
        if (l-r == 0){
            return nums[r];
        } else {
            int mid = (l+r)/2;
            int left = major(nums, l, mid);
            int right = major(nums, mid + 1, r);

            if (left == right){
                return left;
            } else{
                return (count(nums, l , mid, left) > count(nums, mid + 1, r, right)) ? left : right;
            }
        }
    }
    public int count(int[] nums, int l, int r, int val){
        int count = 0;
        for (int i = l; i <= r; i ++){
            if (nums[i] == val) count ++;
        }
        return count;
    }
}
