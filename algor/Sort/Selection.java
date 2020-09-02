package algor.Sort;

public class Selection extends Template{
    
    public static void sort(Comparable[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min_idx = i;
            for (int j = i+1; j < len; j++) {
                if (less(array[j], array[min_idx])) {
                    min_idx= j;
                }
            }
            exch(array, i, min_idx);
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