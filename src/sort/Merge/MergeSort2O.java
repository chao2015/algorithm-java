package sort.Merge;

import sort.Insertion.InsertionSort;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class MergeSort2O {

    private MergeSort2O(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        Comparable[] aux = new Comparable[n];
        sort(arr, aux, 0, n-1);

    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    // 其中aux为完成merge过程所需要的辅助空间
    private static void sort(Comparable[] arr, Comparable[] aux, int l, int r) {

        // 优化2: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r-l)/2;
        sort(arr, aux, l, mid);
        sort(arr, aux, mid+1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid+1]) > 0)
            merge(arr, aux, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    // 其中aux为完成merge过程所需要的辅助空间
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
