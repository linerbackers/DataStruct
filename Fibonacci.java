package Sort;

public class Fibonacci {
	
	/**
	 * �ݹ鷨��ʱ�临�Ӷ� n��ָ��
	 * @param n
	 * @return
	 */
	
	public int fibonacci(int n){
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	/**
	 * �����ݹ����֮������������Ϊ�ظ��ļ� ��̫�࣬����ֻˣ��취�����ظ���������ˡ�
	 * �������ǿ��԰Ѽ����õ� �������м�������������´���Ҫ�����ʱ������������һ�£����ǰ �漺��������Ͳ������ظ������ˡ�
	 * ���򵥵İ취�Ǵ������ϼ��㣬���ȸ���f(0)��f(1)���f(2)���ٸ��� f(1)��.f(2)���f(3)�����Դ����ƾͿ��������n���ˡ�
	 * ��������⣬����˼ ·��ʱ�临�Ӷ��ǩ�(n)��

	 * @param n
	 * @return
	 */
	public static int fibonacci2(int n){
		int f1=1;
		int f2=1;
		int j=2;//��n=2��ʼ���㣬���Ҫע�⣬���׸��
		if(n==0||n==1){
			return 1;
		}
		while(j<=n){
			int temp=f1+f2;
			f1=f2;
			f2=temp;
			j++;
		}
		return f2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=fibonacci2(5);
		System.out.println(n);
	}

}
