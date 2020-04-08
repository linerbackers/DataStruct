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
		int[] temp=new int[arr.length];//������ǰ���Ƚ���һ�����ȵ���ԭ���鳤�ȵ���ʱ���飬����ݹ���Ƶ�����ٿռ�
		mergeSort(arr,0,arr.length-1,temp);
	}

	private void mergeSort(int[] arr, int left, int right, int[] temp) {
		if(left<right){//<
			int mid=(left+right)/2;
			mergeSort(arr, left, mid, temp);//�ݹ�������
			mergeSort(arr, mid+1, right, temp);//�ݹ�������
			merge(arr,left,right,mid,temp);//��ʼ���������ϲ�
		}
	}

	private void merge(int[] arr, int left, int right ,int mid,int[] temp) {
		int i=left;//������ָ��
		int j=mid+1;//������ָ��
		int k=0;//��ʱ����ָ��
		while(i<=mid&&j<=right){
			if(arr[i]>=arr[j]){
				temp[k++]=arr[j++];
			}else{
				temp[k++]=arr[i++];
			}
		}
		
		while(i<=mid){//�����ʣ��Ԫ������temp��
			temp[k++]=arr[i++];
		}
		
		while(j<=right){//��������ʣ��Ԫ������temp��
			temp[k++]=arr[j++];
		}
		
		//��temp�е�Ԫ��ȫ��������ԭ������
		k=0;
		while(left <= right){
	        arr[left++] = temp[k++];
	    }
	}

}
