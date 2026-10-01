package BT_TH;

public class Bai1_10 {
    public static int bs(int[] a, int target){
        int lo = 0; int hi = a.length -1;
        int res = -1;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (a[mid] == target){
                res = mid;
                hi = mid - 1;
            } else if (a[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}
