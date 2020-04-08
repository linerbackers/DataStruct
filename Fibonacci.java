package Sort;

public class Fibonacci {
	
	/**
	 * 递归法，时间复杂度 n的指数
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
	 * 上述递归代码之所以慢，是因为重复的计 算太多，我们只耍想办法避免重复计算就行了。
	 * 比如我们可以把己经得到 的数列中间项保存起来，在下次需要计算的时候我们先杳找一下，如果前 面己经计算过就不用再重复计算了。
	 * 更简单的办法是从下往上计算，首先根据f(0)和f(1)算出f(2)，再根据 f(1)和.f(2)算出f(3)……以此类推就可以算出第n项了。
	 * 很容易理解，这种思 路的时间复杂度是〇(n)。

	 * @param n
	 * @return
	 */
	public static int fibonacci2(int n){
		int f1=1;
		int f2=1;
		int j=2;//从n=2开始计算，这个要注意，容易搞错
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
