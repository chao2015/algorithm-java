package sort.Bubble;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/26.
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int n = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("sort.Bubble.BubbleSort", arr);
    }
}
