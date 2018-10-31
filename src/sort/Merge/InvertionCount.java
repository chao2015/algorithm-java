package sort.Merge;

import sort.common.SortTestHelper;

import java.util.Arrays;

/**
 * Created by chao on 2018/10/31.
 */

// 归并排序的优化用于求【逆序数对】
public class InvertionCount {

    public static long solve(Comparable[] arr) {
        return solve(arr, 0, arr.length-1);
    }

    // 求arr[l..r]范围的逆序数对个数
    private static long solve(Comparable[] arr, int l, int r) {

        if (l >= r)
            return 0L;

        int mid = l+(r-l)/2;
        // 求出 arr[l...mid] 范围的逆序数
        long res1 = solve(arr, l, mid);
        // 求出 arr[mid+1...r] 范围的逆序数
        long res2 = solve(arr, mid + 1, r);

        return res1 + res2 + merge(arr, l, mid, r);
    }

    // merge函数求出在arr[l...mid]和arr[mid+1...r]有序的基础上, arr[l...r]的逆序数对个数
    private static long merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化逆序数对个数 res = 0
        long res = 0L;

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for (int k=l; k <= r; k++) {
            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j ++;
            } else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i ++;
            } else if( aux[i-l].compareTo(aux[j-l]) <= 0 ){  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i-l];
                i ++;
            } else{   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j-l];
                j ++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - j + 1
                res += (long)(mid - i + 1);
            }
        }
        return res;
    }

    // 测试 InversionCount
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1: 测试随机数组
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr) );

        // 测试2: 测试完全有序的数组
        // 结果应该为0
        arr = SortTestHelper.generateOrderedArray(N);
        System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr) );

        // 测试3: 测试完全逆序的数组
        // 结果应改为 N*(N-1)/2
        arr = SortTestHelper.generateInversedArray(N);
        System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr) );

//        Test Inversion Count for Random Array, n = 1000000 :249865395833
//        Test Inversion Count for Ordered Array, n = 1000000 :0
//        Test Inversion Count for Inversed Array, n = 1000000 :499999500000 =(999999+1)*999999/2
    }

}
