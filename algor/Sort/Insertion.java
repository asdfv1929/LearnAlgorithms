package algor.Sort;

public class Insertion extends Template {
    
    // 交换元素
    // public static void sort(Comparable[] arr) {
    //     int len = arr.length;
    //     for (int i = 1; i < len; i++) {
    //         for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
    //             exch(arr, j, j-1);
    //         }
    //     }
    // }

    // 元素右移
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            Comparable temp = arr[i];
            int j = i-1;
            while (j >= 0 && less(temp, arr[j])) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4};
        Insertion.sort(arr);
        Insertion.print(arr);
        assert isSorted(arr);
    }

}