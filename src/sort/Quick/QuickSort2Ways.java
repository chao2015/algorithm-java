package sort.Quick;

import sort.Insertion.InsertionSort;

/**
 * Created by chao on 2018/10/30.
 */
public class QuickSort2Ways {

    private QuickSort2Ways(){}

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if(r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    // 以arr[r]为pivot
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, r, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[r];

        // arr[l...i) <= v; arr(j...r-1] >= v
        int i = l, j = r-1;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            while (i <= r-1 && arr[i].compareTo(v) < 0)
                i++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            while (j >= l && arr[j].compareTo(v) > 0)
                j--;

            if (i > j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }
        // arr[i]>v, arr[j]<v
        swap(arr, r, i);

        return i;
    }

    // 以arr[l]为pivot
    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition2(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html

            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    private static void swap(Object[] arr, int index1, int index2) {
        Object t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }

}
