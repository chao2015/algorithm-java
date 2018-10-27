package sort.Bubble;

/**
 * Created by chao on 2018/10/26.
 */
// 每一趟Bubble Sort都将最大的元素放在了最后的位置
// 所以下一次排序, 最后的元素可以不再考虑
public class BubbleSort {

    private BubbleSort(){};

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        boolean swapped = false;

        for (int i=0; i<n; i++) {
            for (int j=1; j<n-i; j++) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    swap(arr, j-1, j);
                }
            }
        }
    }

    private static void swap(Object[] arr, int index1, int index2) {
        Object t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

}
