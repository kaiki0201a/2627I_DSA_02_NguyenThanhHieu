package BT_TH;
/*
Ý tưởng:
- Với n chẵn: chia đôi để nhân
- Với n lẻ: chia đổi và nhân với x
 */


public class LC50_Pow {
    public double myPow(double x, int n) {
        return poww(x, (long) n);
    }
    public double poww(double x, long n){
        if (n==0){
            return 1;
        }
        if (n < 0){
            return 1/ poww(x, -n);
        }
        double half = poww(x, n/2);
        if (n % 2 == 0){
            return half * half;
        } else {
            return half*half*x;
        }
    }
}
