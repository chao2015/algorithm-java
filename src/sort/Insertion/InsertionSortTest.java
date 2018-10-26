package sort.Insertion;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/26.
 */
public class InsertionSortTest {

    public static void main(String[] args) {
        int n = 20000;  // 0.74573072 s
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("sort.Insertion.InsertionSort", arr);
    }
}
