package Sort;

import java.util.Arrays;

public class DirectInsertionSort {

	/*�㷨�ȶ����ʺ���ʽ�洢��˳��洢*/
	/*�㷨˼�룺��ʼa[1]��һ���Ѿ��źõ����У���ʣ��Ԫ�ز����������С�
	����һ����Ҫ�Ƚϵ�Ԫ�ط���temp
	��������Ƚϴ�С��������ź���ĸ�С����Ѳ���λ�ú����Ԫ��ȫ������һλ��Ȼ��Ԫ��ֱ�Ӳ���*/
	static int[] DirectInsertionSort(int a[],int n){
		int j;
		for(int i=1;i<n;i++){
			int temp=a[i];//���׼�������ֵ
			for(j=i-1;temp<a[j];j--){
				a[j+1]=a[j];
			}
			a[j+1]=temp;//��ʱj--���1,
						//�˴�����ʹ��j++��j++������j���ٸ�ֵ+1����ʱ�����ḳֵ����ȷλ�á�Ҫôj+1��Ҫô++j
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=DirectInsertionSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
