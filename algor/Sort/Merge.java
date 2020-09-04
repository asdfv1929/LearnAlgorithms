package algor.Sort;

/**
 * 归并排序
*/
public class Merge extends Template{
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo; int j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];                   //左半边元素结束，将右半边元素复制到原数组
            else if (j > hi) a[k] = aux[i++];               //右半边元素结束，将左半边元素复制
            else if (less(aux[j], aux[i])) a[k] = aux[j++]; //取较小值
            else a[k] = aux[i++];                           //较小值
        }
    }


//    public static void sort(Comparable[] a) {
//        aux = new Comparable[a.length];
//        sort(a, 0, a.length-1);
//    }
    //自顶向下的归并排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) { return ; }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);        //将左半边排序
        sort(a, mid+1, hi);   //将右半边排序
        merge(a, lo, mid, hi);   //归并
    }

    //自底向上的归并排序
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz=sz+sz) {
            for (int lo = 0; lo < N-sz; lo+=sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4, 1};
        Merge.sort(arr);
        Merge.print(arr);
        assert isSorted(arr);
    }
}