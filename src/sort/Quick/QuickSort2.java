package sort.Quick;

import sort.Insertion.InsertionSort;

/**
 * Created by chao on 2018/10/29.
 */
public class QuickSort2 {

    private QuickSort2(){}

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, r, (int)(Math.random()*(r-l+1))+l );

        Comparable pivot = arr[r];

        int p = l; // arr[l...p-1] < pivot ; arr[p...i-1) > pivot
        // i扫描要比较的数，p记录pivot位置，即比pivot小的数的后一个位置（第一个大于pivot的位置）
        for (int i=l; i<r; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                swap(arr, p, i);
                p++;
            }
        }
        swap(arr, r, p);
        return p;

    }

    private static void swap(Object[] arr, int index1, int index2) {
        Object t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

}
