public class test {
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean sw;
        int res = 0;

        for (int i = 0; i < arr1.length; i++){
            sw = true;
            for (int j : arr2){
                System.out.println(arr1[i]);
                System.out.println(j);
                if (Math.abs(arr1[i] - arr2[j]) > d){
                    sw = false;
                    break;
                }
            }

            if (sw){
                res++;
            }
        }

        return res;
    }
}