package cn.echohce.sorting_algorigthm;

/**
 * Created by lin on 2016/4/21.
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int [] list = {9,4,5,1,3,2,7,8,6};
        quickSort(list);
        for (int i : list)
        {
            System.out.print(i+ " ");
        }
    }
    public static void quickSort(int [] list){
        quickSort(list,0,list.length-1);
    }

    public  static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] list, int low, int high) {
        int pivot = list[low];
        while (low < high) {
            while (low < high && list[high] >= pivot)
                high--;
            if (low < high)
                list[low++] = list[high];
            while (low < high && list[low] <= pivot)
                low++;
            if (low < high)
                list[high--] = list[low];
        }
        list[low] = pivot;
        return low;
    }
}
