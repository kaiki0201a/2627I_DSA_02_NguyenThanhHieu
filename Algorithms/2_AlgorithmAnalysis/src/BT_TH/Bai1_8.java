package BT_TH;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
Viết một chương trình tính số cặp số có giá trị bằng nhau từ một file chứa các số int.
Nếu thuật toán của bạn đang là bậc hai, hãy tìm cách sử dụng Arrays.sort() để có thuật toán NlogN. (Arrays.sort() là hàm sắp xếp mảng sử dụng thuật toán loại NlogN)
 */
public class Bai1_8{
    public static long countPairs(int[] a){
        if (a == null || a.length < 2){
            return 0;
        }

        // 1. Sort(a)
        Arrays.sort(a);

        long res = 0;
        long rlength = 1;
        for (int i = 1; i < a.length; i++){
            if (a[i] == a[i-1]){
                rlength++;
            } else {
                res += (rlength * (rlength) - 1)/2;
                rlength = 1;
            }
        }

        // Cộng nốt số cặp của nhóm cuối cùng
        res += (rlength * (rlength - 1)) / 2;
        return res;
    }

    static void main(String[] args) {
        if (args.length == 0) {
            StdOut.println("Usage: java EqualPairsCount <filename>");
            return;
        }

        // Đọc mảng số nguyên từ file
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        long count = countPairs(a);
        StdOut.println("So cap bang nhau: " + count);
    }
}