package sort.Quick;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/30.
 */
public class CompareTest8 {

    // 比较Merge Sort和Quick Sort 2 Ways两种排序算法的性能效率
    // Quick Sort 2 Ways性能最优

    // 比较Merge Sort和双路快速排序和三路快排三种排序算法的性能效率
    // 对于包含有大量重复数据的数组, 三路快排有巨大的优势
    // 对于一般性的随机数组和近乎有序的数组, 三路快排的效率虽然不是最优的, 但是是在非常可以接受的范围里
    // 因此, 在一些语言中, 三路快排是默认的语言库函数中使用的排序算法。比如Java
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Quick.QuickSort2", arr2);
        SortTestHelper.testSort("sort.Quick.QuickSort2Ways", arr3);
        SortTestHelper.testSort("sort.Quick.QuickSort3Ways", arr4);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 双路快速排序算法也可以轻松处理近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
        SortTestHelper.testSort("sort.Quick.QuickSort2", arr2);
        SortTestHelper.testSort("sort.Quick.QuickSort2Ways", arr3);
        SortTestHelper.testSort("sort.Quick.QuickSort3Ways", arr4);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        // 使用双快速排序后, 我们的快速排序算法可以轻松的处理包含大量元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Merge.MergeSort2", arr1);
//        SortTestHelper.testSort("sort.Quick.QuickSort2", arr2);
        SortTestHelper.testSort("sort.Quick.QuickSort2Ways", arr3);
        SortTestHelper.testSort("sort.Quick.QuickSort3Ways", arr4);


    }

}
