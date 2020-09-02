package algor.Sort;

/**
 * 快速排序
*/
public class Quick extends Template{
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    // 快速排序的切分
    private static int partition(Comparable[] a, int lo, int hi) {
        // 左右扫描的指针
        int i = lo;        // 从左往右扫描指针
        int j = hi + 1;    // 从右往左扫描指针
        Comparable v = a[lo]; // 获取切分点，为指定范围内首值
        while (true) {
            // 从左往右遍历，查找比v大的值
            while (less(a[++i], v))
                if (i == hi) break;
            // 从右往左遍历，查找比v小的值 
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            // 
            exch(a, i, j);
        }
        // 将切分点放入正确的位置，此时实现切分点左侧全小于它，右侧全大于它
        exch(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4, 1};
        Quick.sort(arr);
        Quick.print(arr);
        if (isSorted(arr)) 
            System.out.println("Sorted");
    }
}