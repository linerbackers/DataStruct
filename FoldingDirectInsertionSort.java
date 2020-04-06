package Sort;

import java.util.Arrays;

public class FoldingDirectInsertionSort {

	/*�۰��������ֻ�ʺ�˳�����ֻ�Ǽ����˱Ƚϴ���ΪO��nlog2n����ȴû�м����ƶ���������ΪO��n^2)*/
	/*�㷨˼�룺
	 * ÿ���۰룬Ȼ�����м�ֵ��Ҫ�����ֵ���бȽ�
	 * */
	static int[] FoldHalfDirectInsertionSort(int a[],int n){
		int j;
		int low,mid,high;
		for(int i=1;i<n;i++){
			int temp =a[i];
			low=0;high=i-1;
			while(low<=high){
				mid=(low+high)/2;
				if(temp>a[mid]){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
			//�˴����Ҳ����ֱ�Ӳ��������㷨���⣬����ʹ��j++��high++��Ӧʹ��++j,++high
			for(j=i-1;j>=high+1;j--){
				a[j+1]=a[j];
			}
			a[high+1]=temp;
		}
		
		return a;
		
	}
	
	
	public static void main(String[] args) {
		int a[]={0,4,2,6,1,2,13,19,16,33,29,39,31,87};
		int[] b=FoldHalfDirectInsertionSort(a,a.length);
		System.out.print(Arrays.toString(b));
	}
}
