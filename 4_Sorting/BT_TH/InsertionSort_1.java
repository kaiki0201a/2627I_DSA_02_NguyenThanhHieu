package BT_TH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort_1 {
    public static void insertionSort1 (int n, List<Integer> arr){
        StringBuilder sb = new StringBuilder();
        if (n <= 1){
            return;
        }
        n -= 1;

        int val = arr.get(n);
        while (n > 0 && arr.get(n-1) > val){
            arr.set(n, arr.get(n-1));
            n -= 1;
            sb.append(arr.stream().map(Object::toString).collect(Collectors.joining(" "))).append("\n");
        }

        arr.set(n, val);
        sb.append(arr.stream().map(Object::toString).collect(Collectors.joining(" "))).append("\n");
        System.out.println(sb.toString());

    }
}
