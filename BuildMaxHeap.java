package Sort;

import java.util.Arrays;

public class BuildMaxHeap {
	
	/*大根堆算法思想：对所有具有双亲结点含义的编号从大到小（L[N/2]~1）做出如下调整：
	1）若孩子结点均小于双亲结点，则该结点调整结束
	2）若孩子节点大于双亲结点，则将最大的孩子结点与双亲结点交换，
	并对孩子结点进行1）2），直到出现1）或叶节点*/
	static int[] BuildMaxHeap(int a[],int n){
		for(int i=n/2;i>=0;i--){
			AdjustDown(a,i,n);
		}
		return a;
	}

	static void AdjustDown(int[] a, int k, int n) {
		int temp=a[k];			//1
		for(int i=2*k;i<n;i*=2){//孩子节点
			if(i<n&&a[i]<a[i+1])
				i++; 			//选取左右子树中的最大值
			if(temp>=a[i]){
				break;			//子树最大值也比根小，则跳出
			}else{
				a[k]=a[i];
				k=i;			//2
			}
				
		}
		a[k]=temp;				//与1，2结合相当于把子树和根结点调换
	}

	public static void main(String[] args) {
		int a[]={14,9,6,13,21,10,16,17,2,12};
		int[] b=BuildMaxHeap(a,a.length-1);
		System.out.print(Arrays.toString(b));
	}
}
