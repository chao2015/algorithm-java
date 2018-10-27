package sort.Shell;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class CompareTest4 {
    // 希尔排序性能最好
    //    Test for random array, size = 20000 , random range [0, 20000]
    //    InsertionSort : 0.637833554 s
    //    SelectionSort : 0.683089865 s
    //    SelectionSort2 : 0.380154274 s
    //    ShellSort : 0.014833726 s
    //
    //    Test for more ordered random array, size = 20000 , random range [0,3]
    //    InsertionSort : 0.314258126 s
    //    SelectionSort : 0.351000925 s
    //    SelectionSort2 : 0.64878398 s
    //    ShellSort : 0.010444555 s
    //
    //    Test for nearly ordered array, size = 20000 , swap time = 100
    //    InsertionSort : 0.002711497 s
    //    SelectionSort : 0.27715995 s
    //    SelectionSort2 : 0.224821546 s
    //    ShellSort : 0.010996557 s
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
        SortTestHelper.testSort("sort.Shell.ShellSort", arr4);

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
        SortTestHelper.testSort("sort.Shell.ShellSort", arr4);

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
        SortTestHelper.testSort("sort.Shell.ShellSort", arr4);
    }
}
