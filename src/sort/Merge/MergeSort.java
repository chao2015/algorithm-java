package sort.Merge;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class MergeSort {

    private MergeSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
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
