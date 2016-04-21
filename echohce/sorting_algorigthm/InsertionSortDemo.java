package cn.echohce.sorting_algorigthm;

/**
 * Created by lin on 2016/4/21.
 * 插入排序实现：
 * 已排好的子数列中反复插入一个新元素来对数列值进行排序的
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        int [] list = {9,4,5,1,5,2,7,8,6};
        insertionSort(list);
        for (int i : list)
        {
            System.out.print(i+ " ");
        }
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int current = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > current; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = current;
        }
    }
}
