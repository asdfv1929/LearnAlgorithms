package algor.Sort;

public class Insertion extends Template {
    
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--) {
                exch(arr, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 8, 4};
        Selection.sort(arr);
        Selection.print(arr);
        if (isSorted(arr)) 
            System.out.println("Sorted");
    }

}