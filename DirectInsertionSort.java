package Sort;

import java.util.Arrays;

public class DirectInsertionSort {

	/*算法稳定，适合链式存储和顺序存储*/
	/*算法思想：初始a[1]是一个已经排好的序列，把剩余元素插入子序列中。
	步骤一：把要比较的元素放入temp
	步骤二：比较大小，如果比排好序的更小，则把插入位置后面的元素全部后移一位，然后元素直接插入*/
	static int[] DirectInsertionSort(int a[],int n){
		int j;
		for(int i=1;i<n;i++){
			int temp=a[i];//存放准备插入的值
			for(j=i-1;temp<a[j];j--){
				a[j+1]=a[j];
			}
			a[j+1]=temp;//此时j--多减1,
						//此处不能使用j++，j++是先用j，再赋值+1，此时并不会赋值到正确位置。要么j+1，要么++j
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=DirectInsertionSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
