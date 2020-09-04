package algor.Sort;

public class Heap extends Template{

    private static void sink(Comparable[] a, int i, int j) {

    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
            while (N > 1) {
                exch(a, 1, N--);
                sink(a, 1, N);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4};
        Heap.sort(arr);
        Heap.print(arr);
        assert isSorted(arr);
    }

}
