package sort.Merge;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class CompareTest6 {

    // 优化之后的MergeSort2性能比MergeSort更优

    // 比较Merge Sort和Merge Sort Bottom Up两种排序算法的性能效率
    // 整体而言, 两种算法的效率是差不多的。但是如果进行仔细测试, MergeSort2的归并排序会略胜一筹。
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort", arr2);
        SortTestHelper.testSort("sort.Merge.MergeSort2", arr3);
        SortTestHelper.testSort("sort.Merge.MergeSortBU", arr4);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort", arr2);
        SortTestHelper.testSort("sort.Merge.MergeSort2", arr3);
        SortTestHelper.testSort("sort.Merge.MergeSortBU", arr4);
    }

}
