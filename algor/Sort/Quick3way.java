package algor.Sort;

/**
 * 三向切分的快速排序
 * 数组中存在大量重复元素
 */
public class Quick3way extends Template{
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4, 1};
        Quick3way.sort(arr);
        Quick3way.print(arr);
        if (isSorted(arr))
            System.out.println("Sorted");
    }
}