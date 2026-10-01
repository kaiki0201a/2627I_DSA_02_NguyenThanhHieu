

import edu.princeton.cs.algs4.In;

import java.util.List;

public class Equal_Stacks {
    public static int getSum(List<Integer> h){
        int total = 0;

        for (int i = 0; i < h.size(); i++){
            total += h.get(i);
        }
        return total;
    }
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3){
        int total1 = getSum(h1);
        int total2 = getSum(h2);
        int total3 = getSum(h3);
        int i = 0;
        int j = 0;
        int k = 0;

        while (total1 != total2 || total1 != total3){
            if (total1 > total2 && total1 > total3){
                total1 -= h1.get(i++);
            } else if (total2 > total3){
                total2 -= h2.get(j++);
            } else{
                total3 -= h3.get(k++);
            }
        }

        return total1;
    }
}
