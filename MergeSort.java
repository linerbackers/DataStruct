package Sort;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {
	
	@Test
	public void test(){
		 int[] arr = {8,4,5,7,1,3,6,2};
		 mergeSort(arr);
		 System.out.println(Arrays.toString(arr));
	}

	private void mergeSort(int[] arr) {
		int[] temp=new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		mergeSort(arr,0,arr.length-1,temp);
	}

	private void mergeSort(int[] arr, int left, int right, int[] temp) {
		if(left<right){//<
			int mid=(left+right)/2;
			mergeSort(arr, left, mid, temp);//递归左子树
			mergeSort(arr, mid+1, right, temp);//递归右子树
			merge(arr,left,right,mid,temp);//开始左右子树合并
		}
	}

	private void merge(int[] arr, int left, int right ,int mid,int[] temp) {
		int i=left;//左序列指针
		int j=mid+1;//右序列指针
		int k=0;//临时数组指针
		while(i<=mid&&j<=right){
			if(arr[i]>=arr[j]){
				temp[k++]=arr[j++];
			}else{
				temp[k++]=arr[i++];
			}
		}
		
		while(i<=mid){//将左边剩余元素填充进temp中
			temp[k++]=arr[i++];
		}
		
		while(j<=right){//将右序列剩余元素填充进temp中
			temp[k++]=arr[j++];
		}
		
		//将temp中的元素全部拷贝到原数组中
		k=0;
		while(left <= right){
	        arr[left++] = temp[k++];
	    }
	}

}
