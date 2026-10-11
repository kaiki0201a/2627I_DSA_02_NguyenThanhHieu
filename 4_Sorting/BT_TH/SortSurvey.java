package BT_TH;

import edu.princeton.cs.algs4.In;
import java.util.Arrays;
import java.util.Random;

public class SortSurvey {

    // Bai 1: Insertion Sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    // Bai 2: Selection Sort
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    // Tao du lieu ngau nhien
    public static int[] randomArray(int n, Random rd) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(1_000_001);
        }

        return a;
    }

    // Tao mang da sap xep tang dan
    public static int[] ascendingArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        return a;
    }

    // Tao mang da sap xep giam dan
    public static int[] descendingArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }

        return a;
    }

    // Tao mang co cac phan tu bang nhau
    public static int[] equalArray(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 7);
        return a;
    }

    // Do thoi gian trung binh (ms)
    // Sao chep mang truoc khi do de khong tinh thoi gian copy
    public static double benchmark(
            int[] data, boolean useInsertion, int repetitions) {

        long totalNanos = 0;

        for (int r = 0; r < repetitions; r++) {
            int[] a = data.clone();

            long start = System.nanoTime();

            if (useInsertion) {
                insertionSort(a);
            } else {
                selectionSort(a);
            }

            long end = System.nanoTime();
            totalNanos += end - start;

            // Kiem tra ket qua sap xep
            if (!isSorted(a)) {
                throw new IllegalStateException(
                        "Mang chua duoc sap xep dung!");
            }
        }

        return totalNanos / (double) repetitions / 1_000_000.0;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    // Doc du lieu tu file bang thu vien algs4
    public static int[] readFile(String fileName) {
        In in = new In(fileName);
        return in.readAllInts();
    }

    public static void runCase(
            String type, int[] data, int repetitions) {

        double insertionTime =
                benchmark(data, true, repetitions);

        double selectionTime =
                benchmark(data, false, repetitions);

        System.out.printf(
                "%-18s %8d %8d %14.4f %14.4f%n",
                type, data.length, repetitions,
                insertionTime, selectionTime);
    }

    public static void main(String[] args) {
        String fileName = args.length > 0
                ? args[0]
                : "F:\\algs4-data\\4Kints.txt";

        int[] fileData;

        try {
            fileData = readFile(fileName);
            System.out.println("Doc file thanh cong: " + fileName);
            System.out.println("So phan tu trong file: "
                    + fileData.length);
        } catch (Exception e) {
            fileData = new int[0];
            System.out.println("Khong doc duoc file: " + fileName);
            System.out.println(
                    "Kiem tra lai duong dan va thu vien algs4.");
        }

        int[] sizes = {1000, 5000, 10000};
        Random rd = new Random(12345);

        System.out.printf(
                "%-18s %8s %8s %14s %14s%n",
                "Loai du lieu", "n", "So lan",
                "Insertion(ms)", "Selection(ms)");

        System.out.println(
                "-----------------------------------------------------------------------");

        for (int n : sizes) {
            // (1) Du lieu test tu file
            if (fileData.length >= n) {
                int[] a = Arrays.copyOf(fileData, n);
                runCase("File test", a, 3);
            }

            // (2) Du lieu ngau nhien
            runCase("Ngau nhien", randomArray(n, rd), 5);

            // (3) Da sap xep tang dan
            runCase("Tang dan", ascendingArray(n), 3);

            // (4) Da sap xep giam dan
            runCase("Giam dan", descendingArray(n), 3);

            // (5) Tat ca phan tu bang nhau
            runCase("Bang nhau", equalArray(n), 5);

            System.out.println();
        }
    }
}