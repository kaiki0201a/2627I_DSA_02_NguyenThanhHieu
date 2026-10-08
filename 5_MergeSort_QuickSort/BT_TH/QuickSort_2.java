package BT_TH;


import java.io.*;
import java.util.*;

public class QuickSort_2 {
    public static int partition(List<Integer> arr, int lo, int hi){
        int pivot = arr.get(lo);
        int i = lo - 1;

        for (int j = 0; j <= hi; j++){
            if (arr.get(j) <= pivot){
                i += 1;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(i+1);
        return i;


    }

    public static void quickSort(List<Integer> arr, int lo, int hi){
        if (lo >= hi) {
            return;
        }

        int j = partition(arr, lo, hi); // vi tri pivot
        quickSort(arr, lo, j -1);
        quickSort(arr, j+1, hi);
        for (int i = lo; i <= hi; i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

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
        quickSort(arr, 0, arr.size() - 1);
    }
}