package sort.Quick;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/29.
 */
public class CompareTest7 {

    // 比较Merge Sort和Quick Sort两种排序算法的性能效率
    // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
    // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Quick.QuickSort", arr2);
        SortTestHelper.testSort("sort.Quick.QuickSort2", arr3);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法? :)

        // 加入了随机选择标定点的步骤后, 我们的快速排序可以轻松处理近乎有序的数组
        // 但是对于近乎有序的数组, 其效率比优化后的归并排序要低, 但完全再容忍范围里
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Quick.QuickSort2", arr2);  // stack overflow


    }
}
