package cn.echohce.sorting_algorigthm;

/**
 * Created by lin on 2016/4/21.
 * 选择排序算法实现
 * 步骤：先找到数列中最小的数，然后放到数列的最前面。
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] list = {2, 4, 5, 1, 5, 2, 5};
        selectSort(list);
        for (double i : list) {
            System.out.print(i + " ");
        }
    }

    public static void selectSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int current = list[i];
            int currentIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentIndex > list[j]) {
                    current = list[j];
                    currentIndex = j;
                }
            }
            // 交换list[i]和current
            if (currentIndex != i) {
                list[currentIndex] = list[i];
                list[i] = current;
            }
        }
    }
}

