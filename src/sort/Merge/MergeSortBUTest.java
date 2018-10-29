package sort.Merge;

import sort.common.SortTestHelper;

/**
 * Created by chao on 2018/10/29.
 */
public class MergeSortBUTest {

    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort.Merge.MergeSortBU", arr);

        return;
    }
}
