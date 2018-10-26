package sort.Insertion;

/**
 * Created by chao on 2018/10/26.
 */
public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i=0; i<n; i++) {

            // 寻找元素arr[i]合适的插入位置

            // 写法1
//            for (int j=i; j>0; j--) {
//                if (arr[j].compareTo(arr[j-1]) < 0)
//                    swap(arr, j, j-1);
//                else
//                    break;
//            }

            // 写法2
//            for (int j=i; j>0 && arr[j].compareTo(arr[j-1])<0; j--)
//                swap(arr, j, j-1);

            // 写法3
            Comparable e = arr[i];
            int j = i;
            for (; j>0 && arr[j-1].compareTo(e) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }

    private static void swap(Object[] arr, int index1, int index2) {
        Object t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }
}
