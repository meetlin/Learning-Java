package cn.echohce.sorting_algorigthm;

/**
 * Created by lin on 2016/4/21.
 * 归并排序实现
 * 比如（9 4 5 1 3 2 7 8 6)
 * 拆分为      (9 4 5 1)  |  (3 2 7 8 6)
 * ---->  (9 4) | (5 1)         (3 2) | (7 8 6)
 * ---->(9)|(4)  (5) | (1)  (3) | (2)  (7) | (8)(6)
 * 再合并 49 | 15 | 23 | 678
 * ----> 1459 | 23678
 * ----> 123456789
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int [] list = {9,4,5,1,3,2,7,8,6};
        mergeSort(list);
        for (int i : list)
        {
            System.out.print(i+ " ");
        }
    }

    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // 前半部分进行递归
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            //后半部分进行递归
            int[] secondHalf = new int[list.length - list.length / 2];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalf.length);
            mergeSort(secondHalf);

            // 归并
            int[] temp = merge(firstHalf, secondHalf);
            System.arraycopy(temp, 0, list, 0, temp.length);
        }
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int result[] = new int[firstHalf.length + secondHalf.length];
        int currentFirst = 0;
        int currentSecond = 0;
        int currentResult = 0;
        while (currentFirst < firstHalf.length  && currentSecond < secondHalf.length) {
            if (firstHalf[currentFirst] > secondHalf[currentSecond]) {
                result[currentResult++] = secondHalf[currentSecond++];
            } else result[currentResult++] = firstHalf[currentFirst++];
        }
        while (currentFirst < firstHalf.length){
            result[currentResult++] = firstHalf[currentFirst++];
        }
        while (currentSecond < secondHalf.length)
        {
            result[currentResult++] = secondHalf[currentSecond++];
        }
        return result;
    }
}
