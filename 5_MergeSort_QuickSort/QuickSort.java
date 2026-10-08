/*
1. Choose a Pivot (first, last, median,...)
2. Partition the Array
    + Re arrange the array around the pivot.
3. Recursively call

Base case: stopin when there is only one element left in the sub-array
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class QuickSort {
    // Cach 1: chia thanh 3 mang left, equal, right
    public static List<List<Integer>> partition1(List<Integer> arr)
    {
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++){
            int val = arr.get(i);

            if (val > pivot){
                right.add(val);
            } else if (val < pivot){
                left.add(val);
            } else
                equal.add(val);
        }
        return List.of(left, equal, right);
    }
    public static List<Integer> QuickSort1(List<Integer> arr){
        if (arr.size() <= 1) return arr;

        List<List<Integer>> parts = partition1(arr);

        List<Integer> res = new ArrayList<>(QuickSort1(parts.get(0)));
        res.addAll(parts.get(1));
        res.addAll(QuickSort1(parts.get(2)));

        System.out.println(
                res.stream().map(String::valueOf).collect(Collectors.joining(" "))
        );

        return res;
    }

    // Cach 2: duyet tu trai sang -> phan tu > pivot, tu phai sang -> phan tu < pivot
    // Cach nay khong giup giu lai thu tu
    public static int partition2(List<Integer> arr, int lo, int hi){
        int i = lo; int j = hi+1;
        int pivot = arr.get(lo);

        while (true){
            while (arr.get(++i) < pivot){  // Tra ve dung vi tri ma tai do > pivot
                if (i == hi) break;
            }
            while (arr.get(--j) > pivot){  // Tra ve dung vi tri ma tai do < pivot
                if (j == lo) break;
            }
            if (i >= j) break;

            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
        arr.set(lo, arr.get(j));
        arr.set(j, pivot);

        return j;
    }

    public static void quickSort2(List<Integer> arr, int lo, int hi){
        if (lo >= hi) return;
        int j = partition2(arr, lo, hi);

        quickSort2(arr, lo, j-1);
        quickSort2(arr, j+1, hi);
    }

    // Cach 3: Duyet tu trai sang phai va don be hon ve mot phia
    // hoac duyet tu phai sang trai de don lon hon ve mot phia
    // Tim vi tri dung
    // Lam dao lon vi tri
    public static int partition3(List<Integer> arr, int lo, int hi){
        int i = hi + 1;
        int pivot = arr.get(lo);

        for (int j = hi; j > lo; j--){
            if (arr.get(j) >= pivot){
                int temp = arr.get(--i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        arr.set(lo, arr.get(--i));
        arr.set(i, pivot);

        return i;
    }

    public static List<Integer> quickSort3(List<Integer> arr, int lo, int hi){
        if (lo < hi) {

            int pi = partition3(arr, lo, hi);
            quickSort3(arr, lo, pi - 1);
            quickSort3(arr, pi + 1, hi);

            for (int i = lo; i <= hi; i++){
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
        return arr;
    }


    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i ++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> i = quickSort3(arr, 0, arr.size() -1);
    }
}
