package cn.echohce.sorting_algorigthm;

/**
 * Created by lin on 2016/4/21.
 * 冒泡排序实现：
 * 第一次遍历后，最后一个为最大数
 * 第二次遍历后，最后第二个为第二大的数
 * ...
 * 持续到所有遍历结束
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] list = {9, 4, 5, 1, 5, 2, 7, 8, 6};
//        bubbleSort(list);
//        for (int i : list) {
//            System.out.print(i + " ");
//        }
        bubbleSortBetter(list);
        for (int i : list)
        {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
    // 改进的冒泡排序,判断当次遍历有没有发生交换，如果没有那么下次就不需要遍历了。
    public static void bubbleSortBetter(int [] list)
    {
        boolean needNextPass = true;
        for (int i = 1; i< list.length && needNextPass;i++)
        {
            needNextPass = false;
            for (int k = 0; k< list.length-i;k++)
            {
                if (list[k] > list[k+1]){
                    int temp = list[k];
                    list[k] = list[k+1];
                    list[k+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
