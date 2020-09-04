package algor.Sort;

/**
 * 冒泡排序
*/
public class Bubble extends Template{

    // 冒泡排序
    public static void sort(Comparable[] a) {
        int N = a.length;
        if (N == 0) return;
        for (int i = 0; i < N; i++) {
            //标记是否发生交换，若未发生交换，则数组已序
            boolean swap = false;
            for (int j = 0; j < N-1-i; j++) {
                if (a[j+1].compareTo(a[j]) < 0) {
                    exch(a, j+1, j);
                    swap = true;
                }
            }
            if (!swap) 
                break;
        }
    }

    // 冒泡排序改进
    // 一左一右两指针
    // 从左往右扫描，将较大元素右移
    // 从右往左扫描，较小元素左移
    public static void sort2way(Comparable[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (a[i].compareTo(a[i+1]) > 0) exch(a, i, i+1);
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i].compareTo(a[i-1]) < 0) exch(a, i, i-1);
            }
            left++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4};
        Bubble.sort2way(arr);
        Bubble.print(arr);
    }
}