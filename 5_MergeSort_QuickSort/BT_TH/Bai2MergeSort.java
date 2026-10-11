package BT_TH;

import edu.princeton.cs.algs4.In;
import java.util.Arrays;
import java.util.Random;

public class Bai2MergeSort {

    // Thuat toan Merge Sort
    public static void mergeSort(int[] a) {
        if (a.length < 2) {
            return;
        }

        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(
            int[] a, int[] aux, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        sort(a, aux, left, mid);
        sort(a, aux, mid + 1, right);

        merge(a, aux, left, mid, right);
    }

    private static void merge(
            int[] a, int[] aux,
            int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > right) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static int[] randomArray(int n) {
        Random rd = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(100000);
        }

        return a;
    }

    public static int[] ascendingArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        return a;
    }

    public static int[] descendingArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }

        return a;
    }

    public static int[] equalArray(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 5);
        return a;
    }

    public static double measureTime(
            int[] data, int repetitions) {

        long total = 0;

        for (int i = 0; i < repetitions; i++) {
            int[] a = data.clone();

            long start = System.nanoTime();
            mergeSort(a);
            long end = System.nanoTime();

            total += end - start;
        }

        return total / (double) repetitions / 1_000_000.0;
    }

    public static void main(String[] args) {

        // Doc du lieu tu file
        In in = new In("F:\\algs4-data\\1Kints.txt");
        int[] fileData = in.readAllInts();

        System.out.println("LOAI DU LIEU,N,THOI GIAN (ms)");

        // 1. Du lieu file
        System.out.println("File," + fileData.length + ","
                + measureTime(fileData, 3));

        // 2-5. Cac loai du lieu tu sinh
        int[] sizes = {1000, 2000, 4000, 8000};

        for (int n : sizes) {
            System.out.println("Ngau nhien," + n + ","
                    + measureTime(randomArray(n), 5));

            System.out.println("Tang dan," + n + ","
                    + measureTime(ascendingArray(n), 3));

            System.out.println("Giam dan," + n + ","
                    + measureTime(descendingArray(n), 3));

            System.out.println("Bang nhau," + n + ","
                    + measureTime(equalArray(n), 3));
        }
    }
}
