package sort.Shell;

/**
 * Created by chao on 2018/10/27.
 */
public class ShellSort {

    private ShellSort(){};

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int incrementNum = n / 3;
        while (incrementNum >= 1) {
            // 对 arr[i], arr[i-incrementNum], arr[i-2*incrementNum]... 使用插入排序
            for (int i=0; i<n; i++) {
                Comparable e = arr[i];
                int j = i;
                for (; j>=incrementNum && arr[j-incrementNum].compareTo(e) >0; j-=incrementNum)
                    arr[j] = arr[j-incrementNum];
                arr[j] = e;
            }
            incrementNum /= 3;
        }
    }
}
