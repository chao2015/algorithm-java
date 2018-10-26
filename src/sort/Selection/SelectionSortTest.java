package sort.Selection;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/26.
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        int n = 20000;  // 0.837452121 s
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SelectionSort.sort(arr);
        SortTestHelper.testSort("sort.Selection.SelectionSort", arr);

    }
}
