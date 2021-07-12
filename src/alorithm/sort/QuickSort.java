package alorithm.sort;

/**
 * 快速排序
 * @date 2020-11-30 10:44
 * @author gaolingfeng
 */
public class QuickSort {
    public static void main(String[] args){
        int[] array = {2,4,6,9,1,22,56,3};
        sort(array,0,array.length-1);
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void sort(int[] s,int left,int right){
        if(left >= right){
            return;
        }

        int i,j,base,temp;
        i = left;
        j = right;
        base = s[i];

        while (i < j){
            //先看右边，依次往左递减
            //先从右往左找一个比基准数小的数
            while (base <= s[j] && i<j){
                j--;
            }
            while (base >= s[i] && i<j){
                i++;
            }
            //这时，i下标的数大于等于基准数，j下标的数小于基准数
            //交换i j 下标的位置
            if(i < j){
                temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
        //跳出while循环，说明 i j相遇了，将基准数放到ij共指向的位置
        s[left] = s[i];
        s[i] = base;

        //分别处理左右数组
        sort(s,left,j-1);
        sort(s,j+1,right);
    }
}
