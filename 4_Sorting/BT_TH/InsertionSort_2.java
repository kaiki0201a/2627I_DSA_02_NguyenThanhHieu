package BT_TH;

import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort_2 {
    public static void insertionSort2(int n, List<Integer> arr){
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++){
            int j = i;
            int val = arr.get(i);
            while (j > 0 && arr.get(j-1) > val){
                arr.set(j, arr.get(j-1));
                j--;
            }
            arr.set(j, val);

            sb.append(arr.stream().map(Object::toString).collect(Collectors.joining(" "))).append("\n");
        }
        System.out.println(sb.toString());
    }
}
