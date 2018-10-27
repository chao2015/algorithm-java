package sort.Bubble;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/26.
 */
public class CompareTest3 {
    // BubbleSort性能最差
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);
        SortTestHelper.testSort("sort.Bubble.BubbleSort", arr4);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);
        SortTestHelper.testSort("sort.Bubble.BubbleSort", arr4);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);
        SortTestHelper.testSort("sort.Bubble.BubbleSort", arr4);
    }
}
