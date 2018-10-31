package sort.Merge;

import sort.Insertion.InsertionSort;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class MergeSortBUO {

    private MergeSortBUO(){}

    // 自底向上的归并排序可以对链表实现O(nlogn)的排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 对于小数组, 使用插入排序优化
        for(int i=0; i<n; i+=16)
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        Comparable[] aux = new Comparable[n];
        for(int sz=16; sz<n ; sz+=sz)
            for(int i=0; i+sz<n; i+=sz+sz)
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if(arr[i+sz-1].compareTo(arr[i+sz]) > 0)
                    merge(arr, aux, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, Comparable[] aux, int l, int mid, int r) {

        System.arraycopy(arr, l, aux, l, r-l+1);

        // 初始化，indexL指向左半部分的起始索引位置l；indexR指向右半部分起始索引位置mid+1
        int indexL = l;
        int indexR = mid+1;
        for (int i=l; i<=r; i++) {
            if (indexL > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[i] = aux[indexR];
                indexR++;
            } else if (indexR > r) {  // 如果右半部分元素已经全部处理完毕
                arr[i] = aux[indexL];
                indexL++;
            } else if (aux[indexL].compareTo(aux[indexR]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[i] = aux[indexL];
                indexL++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[i] = aux[indexR];
                indexR++;
            }
        }
    }
}
