package algor.Sort;

/**
 * 希尔排序
*/
public class Shell extends Template {
    public static void sort(Comparable[] array) {
        int len = array.length;
        int h = 1;
        if (h < len / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                    exch(array, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4};
        Shell.sort(arr);
        Shell.print(arr);
        if (isSorted(arr)) 
            System.out.println("Sorted");
    }
}