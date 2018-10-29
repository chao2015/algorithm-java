package sort.Merge;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/27.
 */
public class MergeSortTest {

    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.Merge.MergeSort", arr);
    }
}
