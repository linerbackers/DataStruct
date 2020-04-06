package Sort;

import java.util.Arrays;

public class BuildMaxHeap {
	
	/*������㷨˼�룺�����о���˫�׽�㺬��ı�ŴӴ�С��L[N/2]~1���������µ�����
	1�������ӽ���С��˫�׽�㣬��ý���������
	2�������ӽڵ����˫�׽�㣬�����ĺ��ӽ����˫�׽�㽻����
	���Ժ��ӽ�����1��2����ֱ������1����Ҷ�ڵ�*/
	static int[] BuildMaxHeap(int a[],int n){
		for(int i=n/2;i>=0;i--){
			AdjustDown(a,i,n);
		}
		return a;
	}

	static void AdjustDown(int[] a, int k, int n) {
		int temp=a[k];			//1
		for(int i=2*k;i<n;i*=2){//���ӽڵ�
			if(i<n&&a[i]<a[i+1])
				i++; 			//ѡȡ���������е����ֵ
			if(temp>=a[i]){
				break;			//�������ֵҲ�ȸ�С��������
			}else{
				a[k]=a[i];
				k=i;			//2
			}
				
		}
		a[k]=temp;				//��1��2����൱�ڰ������͸�������
	}

	public static void main(String[] args) {
		int a[]={14,9,6,13,21,10,16,17,2,12};
		int[] b=BuildMaxHeap(a,a.length-1);
		System.out.print(Arrays.toString(b));
	}
}
