import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NaturalMergeSort {
    public static void merge(List<Integer> arr, List<Integer> aux, int lo, int mid, int hi) {
        if (arr.get(mid) <= arr.get(mid+1)) return;

        for (int i = lo; i <= hi; i++) {
            aux.set(i, arr.get(i));
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr.set(k, aux.get(j++));
            } else if (j > hi) {
                arr.set(k, aux.get(i++));
            } else if (aux.get(i) <= aux.get(j)) {
                arr.set(k, aux.get(i++));
            } else {
                arr.set(k, aux.get(j++));
            }
        }
    }

    public static List<Integer> findEnd(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) > arr.get(i)) {
                res.add(i - 1);
            }
        }

        res.add(arr.size() - 1);

        return res;
    }

    public static List<Integer> naturalMergeSort(List<Integer> arr) {
        int n = arr.size();
        if ( n < 2) return arr;

        List<Integer> endL = findEnd(arr);
        List<Integer> aux = new ArrayList<>(arr);
        List<Integer> nextt = new ArrayList<>();

        int lo, mid, hi;
        while (endL.size() > 1) {
            nextt.clear();

            for (int j = 0; j < endL.size() - 1; j += 2){

                if (j == 0){
                    lo = 0;
                } else lo = endL.get(j-1) + 1;

                mid = endL.get(j);
                hi = endL.get(j+1);

                merge(arr, aux, lo, mid, hi);
                nextt.add(hi);
            }
            if (endL.size() % 2 != 0){
                nextt.add(endL.get(endL.size() - 1));
            }

            endL.clear();
            endL.addAll(nextt);
            nextt.clear();
        }
        return arr;
    }
}
