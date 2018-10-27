package sort.Selection;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/26.
 */
public class CompareTest2 {
    // 比较SelectionSort, SelectionSort2和InsertionSort两种排序算法的性能效率
    // 优化后，插入排序比选择排序性能略好
    // 对于有序性强的数组，插入排序远远优于选择排序
    //    Test for random array, size = 20000 , random range [0, 20000]
    //    InsertionSort : 0.671109518 s
    //    SelectionSort : 0.724769497 s
    //    SelectionSort2 : 0.373436681 s
    //
    //    Test for more ordered random array, size = 20000 , random range [0,3]
    //    InsertionSort : 0.317105859 s
    //    SelectionSort : 0.359093898 s
    //    SelectionSort2 : 0.667297035 s
    //
    //    Test for nearly ordered array, size = 20000 , swap time = 100
    //    InsertionSort : 0.003193303 s
    //    SelectionSort : 0.294546217 s
    //    SelectionSort2 : 0.258841769 s
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr1);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr2);
        SortTestHelper.testSort("sort.Selection.SelectionSort2", arr3);
    }
}
