package Sort;

import java.util.Arrays;

public class SelectSort {

	//算法思想：打擂台，选择最小的站在擂台上
	static int[] SelectSort(int a[],int n){
		int j;
		for(int i=0;i<n-1;i++){//n-1
			int min=i;
			for(j=i+1;j<n;j++){//n
				if(a[min]>a[j]){
					min=j;
				}
			}
			if(min!=j){
				int temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
		return a;
	}
	
	
	
	public static void main(String[] args) {
		int a[]={4,0,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=SelectSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
