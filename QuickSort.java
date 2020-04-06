package Sort;

import java.util.Arrays;

public class QuickSort {

	static int[] QuickSort(int[] a, int low,int high){
		/*算法思想：是对冒泡排序的一种改进。采用分治法
		在待排序表L中任取一个元素作为基准pivot,L【1...k-1】所有元素小于pivot,L【k+1...n】大于pivot
		这一趟排序称为快速排序，然后对两个子表重复上述过程直到结束*/
		if (low < high) {
			int pivot = partition(a, low, high);
			QuickSort(a, low, pivot - 1);
			QuickSort(a, pivot + 1, high);
		}
		return a;
	}
	
	static int partition(int a[],int low,int high){
		int pivot=a[low];//初始默认最低位的为基准
		int count1=0;
		int count2=0;
		while(low<high){
			while(low<high&&pivot<=a[high])
				high--;
			a[low]=a[high];//pivot>high,第一轮把high位置值赋值到基准位置，此时high值可以用来当作temp.且指针停留在high，后面几轮把值放low
			while(low<high&&pivot>=a[low])
				low++;
			a[high]=a[low];//pivot<low，把low位置值赋值到high位置，此时low值可以用来当作temp.且指针停留在low
		}
		a[low]=pivot;
		System.out.println(count1+count2);
		return low;
	}
	
	public static void main(String[] args) {
		//int a[]={4,0,2,6,1,2,13,19,16,33,29,39,31,87};
		int a[]={25,84,21,47,15,27,68,35};
		int[] b=QuickSort(a,0,a.length-1);
		System.out.print(Arrays.toString(b));
	}

}
