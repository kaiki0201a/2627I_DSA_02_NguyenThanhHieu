package BT_TH;
public class Bai1_12 {

    public Bai1_12() {};

    public static void rerange(int[]a, int[] b){
        int i = 0; int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]){
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else if (a[i] > b[j]){
                j += 1;
            } else i += 1;
        }
    }
}
