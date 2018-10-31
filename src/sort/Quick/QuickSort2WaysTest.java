package sort.Quick;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/30.
 */
public class QuickSort2WaysTest {

    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.Quick.QuickSort2Ways", arr);

        return;
    }

}
