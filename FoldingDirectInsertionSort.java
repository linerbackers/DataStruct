package Sort;

import java.util.Arrays;

public class FoldingDirectInsertionSort {

	/*折半插入排序只适合顺序表，它只是减少了比较次数为O（nlog2n），却没有减少移动次数依旧为O（n^2)*/
	/*算法思想：
	 * 每次折半，然后用中间值与要插入的值进行比较
	 * */
	static int[] FoldHalfDirectInsertionSort(int a[],int n){
		int j;
		int low,mid,high;
		for(int i=1;i<n;i++){
			int temp =a[i];
			low=0;high=i-1;
			while(low<=high){
				mid=(low+high)/2;
				if(temp>a[mid]){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
			//此处编程也出现直接插入排序算法问题，不能使用j++和high++，应使用++j,++high
			for(j=i-1;j>=high+1;j--){
				a[j+1]=a[j];
			}
			a[high+1]=temp;
		}
		
		return a;
		
	}
	
	
	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=FoldHalfDirectInsertionSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
