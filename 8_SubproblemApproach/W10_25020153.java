public class W10_25020153 {
    static class MinMax{
        int min, max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

    }
    public static MinMax minMaxArr(int[] arr, int l, int r){
        if (l==r){
            return new MinMax(arr[l], arr[l]);
        }

        int mid = (l+r)/2;

        MinMax left = minMaxArr(arr, l, mid);

        MinMax right = minMaxArr(arr, mid + 1, r);

        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);

        return new MinMax(min, max);
    }

    public static MinMax minMax(int[] arr){
        return minMaxArr(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {

        int[] a = {7, 2, 9, 1, 5, 3, 8, 4};

        MinMax result = minMax(a);

        System.out.println("Min = " + result.min);
        System.out.println("Max = " + result.max);
    }
}
