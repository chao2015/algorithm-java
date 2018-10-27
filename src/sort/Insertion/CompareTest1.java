package sort.Insertion;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/26.
 */
public class CompareTest1 {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 此时，插入排序比选择排序性能略低
    //    Test for random array, size = 20000 , random range [0, 20000]
    //    SelectionSort : 0.830202353 s
    //    InsertionSort : 1.133224556 s

    // 优化后，插入排序比选择排序性能略好？结果似乎相反。规模越小，插入排序比选择排序性能越好
    // 对于有序性强的数组，插入排序远远优于选择排序
    //    Test for random array, size = 20000 , random range [0, 20000]
    //    SelectionSort : 0.544109687 s
    //    InsertionSort : 0.815900113 s
    //
    //    Test for more ordered random array, size = 20000 , random range [0,3]
    //    SelectionSort : 0.358298277 s
    //    InsertionSort : 0.306589717 s
    //
    //    Test for nearly ordered array, size = 20000 , swap time = 100
    //    SelectionSort : 0.280540428 s
    //    InsertionSort : 0.002524146 s
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Selection.SelectionSort", arr1);
        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr2);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Selection.SelectionSort", arr1);
        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr2);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Selection.SelectionSort", arr1);
        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr2);

    }
}
