package Sort;

import java.util.Arrays;

public class BubbleSort {

	/*�㷨˼�룺��ǰ���󣨴Ӻ���ǰ���������ڱȽϣ���Ϊ�����򽻻���
	һ���ǰ�С��Ԫ�ؽ�������һ��λ�ã�������������ð����˳�Ϊð��*/
	static int[] BubbleSort(int a[],int n){
		for(int i=0;i<n;i++){//����n��
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
