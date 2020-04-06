package Sort;

import java.util.Arrays;

public class QuickSort {

	static int[] QuickSort(int[] a, int low,int high){
		/*�㷨˼�룺�Ƕ�ð�������һ�ָĽ������÷��η�
		�ڴ������L����ȡһ��Ԫ����Ϊ��׼pivot,L��1...k-1������Ԫ��С��pivot,L��k+1...n������pivot
		��һ�������Ϊ��������Ȼ��������ӱ��ظ���������ֱ������*/
		if (low < high) {
			int pivot = partition(a, low, high);
			QuickSort(a, low, pivot - 1);
			QuickSort(a, pivot + 1, high);
		}
		return a;
	}
	
	static int partition(int a[],int low,int high){
		int pivot=a[low];//��ʼĬ�����λ��Ϊ��׼
		int count1=0;
		int count2=0;
		while(low<high){
			while(low<high&&pivot<=a[high])
				high--;
			a[low]=a[high];//pivot>high,��һ�ְ�highλ��ֵ��ֵ����׼λ�ã���ʱhighֵ������������temp.��ָ��ͣ����high�����漸�ְ�ֵ��low
			while(low<high&&pivot>=a[low])
				low++;
			a[high]=a[low];//pivot<low����lowλ��ֵ��ֵ��highλ�ã���ʱlowֵ������������temp.��ָ��ͣ����low
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
