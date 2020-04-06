package Sort;

import java.util.Arrays;

public class BubbleSort {

	/*算法思想：从前往后（从后往前）两两相邻比较，若为逆序，则交换。
	一般是把小的元素交换到第一个位置，犹如气泡往上冒，因此称为冒泡*/
	static int[] BubbleSort(int a[],int n){
		for(int i=0;i<n;i++){//进行n趟
			for(int j=i+1;j<n;j++){
				if(a[j]<a[i]){
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		return a;
		
	}
	
	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=BubbleSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
