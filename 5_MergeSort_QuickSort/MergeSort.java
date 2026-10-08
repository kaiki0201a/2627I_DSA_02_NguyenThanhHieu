public class MergeSort {
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];  // Mang phu de mang a co the swap
        }
        int i = lo; int j = mid + 1;

        for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) > 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi-lo)/2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }
}
