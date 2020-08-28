package algor.Other;

/**
 * 确定一组数中第K大的数
 * TopK问题
 * 1. 全部排序，降序，取第K大的数
 * 2. 局部排序，冒泡排序，只冒泡K次，较大值前移
 * 3. 不排序，选择小顶堆，对原数组中前K个数构建小顶堆，之后依次将剩余的数与堆顶比较，小于则忽略，大于则插入堆，并进行调整
*/
public class TopK {

    public int topK(int[] arr, int k) {
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = arr[i];
        }
        // 冒泡排序，较大数前移，降序排列
        for (int i = 0; i < k; i++) {
            for (int j = k-1; j > i; j--) {
                if (tmp[j] > tmp[j-1]) {
                    int temp = tmp[j];
                    tmp[j] = tmp[j-1];
                    tmp[j-1] = temp;
                }
            }
        }
        print(tmp);
        // 遍历剩余数值，若当前数值小于tmp数组的最后（小）数，则忽略
        // 否则，将当前数值与tmp数组中各数进行比较（从后往前），定位
        // 位置找到，则tmp数组中该位置后面的数后移，将当前数值插入到该位置上
        for (int i = k; i < arr.length; i++) {
            if (arr[i] <= tmp[k-1]) {
                continue;
            } else {
                int index = k-1;
                while(index >= 0 && arr[i] > tmp[index]) {
                    index--;
                }
                for (int j2 = k-1; j2 > index+1; j2--) {
                    tmp[j2] = tmp[j2-1];
                }
                tmp[index+1] = arr[i];
            }

        }
        print(tmp);
        return tmp[k-1];
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 9, 2, 6, 16, 18};
        TopK top = new TopK();
        int val = top.topK(nums, 6);
        System.out.println(val);
    }
}