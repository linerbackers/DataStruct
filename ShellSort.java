package Sort;

import java.util.Arrays;

public class ShellSort {
	/*�㷨˼�룬�����������d���з����硾i,i+d,i+2d,i+3d.....i+kd���������
	 * Ȼ��ֱ����ֱ�Ӳ�������
	 * */
	static int[] shellSort(int[] a,int n){
		int j;
		for(int dk=n/2;dk>=1;dk=dk/2){//����󲽳���ʼȡ,ÿ����/2����С����
			for(int i=dk;i<n;i++){
				if(a[i-dk]>a[i]){					//�Բ���Ϊ��λ��ǰһ��ֵ�Ƚ�
					int temp=a[i];					//���¾���ֱ�Ӳ�������˼��
					for(j=i-dk;j>0&&a[j]>temp;j=j-dk){//�˴��ı���j>0��д��ǰ��,��Ϊ��j-dkΪ����ʱ��
						a[j+dk]=a[j];                 //a[j-dk]�ͻ�ȡֵ����Խ�硣������Ҫ��ǰ�ж�j�Ǹ�
					}							//Ϊ��ֱ�Ӳ�����۰벻�ÿ����أ���Ϊ������һ���������ض����ҵ�
					a[j+dk]=temp;			//һ��ֵ��j>=0ʱ������ѭ����������forѭ��,��ϣ��ȡ����̫������ͻȻԽ��
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
