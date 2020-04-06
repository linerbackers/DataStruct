package Sort;

import java.util.Arrays;

public class ShellSort {
	/*算法思想，将排序表按增量d进行分组如【i,i+d,i+2d,i+3d.....i+kd】的特殊表
	 * 然后分别进行直接插入排序。
	 * */
	static int[] shellSort(int[] a,int n){
		int j;
		for(int dk=n/2;dk>=1;dk=dk/2){//从最大步长开始取,每次以/2来缩小步长
			for(int i=dk;i<n;i++){
				if(a[i-dk]>a[i]){					//以步长为单位与前一个值比较
					int temp=a[i];					//以下就是直接插入排序思想
					for(j=i-dk;j>0&&a[j]>temp;j=j-dk){//此处的必须j>0且写在前面,因为当j-dk为负的时候，
						a[j+dk]=a[j];                 //a[j-dk]就会取值数据越界。我们需要提前判断j非负
					}							//为何直接插入和折半不用考虑呢，因为他们是一个个减，必定会找到
					a[j+dk]=temp;			//一个值当j>=0时不满足循环条件跳出for循环,而希尔取步长太长，会突然越界
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=shellSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
