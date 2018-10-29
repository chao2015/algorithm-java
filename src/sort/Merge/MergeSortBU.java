package sort.Merge;

import sort.Insertion.InsertionSort;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class MergeSortBU {

    private MergeSortBU(){}

    // 自底向上的归并排序可以对链表实现O(nlogn)的排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
//        for (int sz = 1; sz < n; sz += sz)
//            for (int i = 0; i + sz < n; i += sz+sz)
                //第1轮：归并从0到sz-1和从sz到2sz-1
                //第2轮：归并从2sz到3sz-1和从3sz到4sz-1
                // ...
//                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for(int i=0; i<n; i+=16)
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for(int sz=16; sz<n ; sz+=sz)
            for(int i=0; i+sz<n; i+=sz+sz)
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if(arr[i+sz-1].compareTo(arr[i+sz]) > 0)
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，indexL指向左半部分的起始索引位置l；indexR指向右半部分起始索引位置mid+1
        int indexL = l;
        int indexR = mid+1;
        for (int i=l; i<=r; i++) {
            if (indexL > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[i] = aux[indexR-l];
                indexR++;
            } else if (indexR > r) {  // 如果右半部分元素已经全部处理完毕
                arr[i] = aux[indexL-l];
                indexL++;
            } else if (aux[indexL-l].compareTo(aux[indexR-l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[i] = aux[indexL-l];
                indexL++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[i] = aux[indexR-l];
                indexR++;
            }
        }
    }
}
