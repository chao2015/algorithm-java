package sort.Merge;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/31.
 */
public class CompareTest9 {

    // 比较MergeSort2和MergeSort2O的性能效率
    // MergeSort2O只开辟了一次辅助空间, 之后将这个辅助空间以参数形式传递给完成归并排序的其他子函数
    // 可以看出 MergeSort2O的性能优于 MergeSort2
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Merge.MergeSort2O", arr2);
        SortTestHelper.testSort("sort.Merge.MergeSortBU", arr3);
        SortTestHelper.testSort("sort.Merge.MergeSortBUO", arr4);


        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Merge.MergeSort2O", arr2);
        SortTestHelper.testSort("sort.Merge.MergeSortBU", arr3);
        SortTestHelper.testSort("sort.Merge.MergeSortBUO", arr4);

        System.out.println();


        return;
    }
}
