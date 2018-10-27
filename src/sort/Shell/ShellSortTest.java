package sort.Shell;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/27.
 */
public class ShellSortTest {

    public static void main(String[] args) {
        int n = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("sort.Shell.ShellSort", arr);
    }

}
