package sort.Selection;

/**
 * Created by chao on 2018/10/26.
 */
public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j=i+1; j<n; j++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
