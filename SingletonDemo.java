package Sort;

public class SingletonDemo {

	/**
	 * 题目：设计一个类，我们只能生成该类的一个实例。
	 * 只能生成一个实例的类是实现了 Singleton (单例）模式的类型
	 * 不好的解法一：只适用于单线程环境
	 * 由于要求只能生成一个实例，
	 * 因此我们必须把构造函数设为私有函数 以禁止他人创建实例。
	 * 我们可以定义一个静态的实例，在需要的时候创建 该实例
	 * @param args
	 */
	
	private SingletonDemo(){
		
	}
	private static SingletonDemo singleton=null;
	
	public SingletonDemo getSingleton1(){
		if(singleton==null){
			singleton=new SingletonDemo();
		}
		return singleton;
	}
	
	/**
	 * 上述代码在Singleton1的静态属性Instance中，只有在instance为null
		的时候才创建一个实例以避免重复创建。同时我们把构造函数定义为私有 函数，这样就能确保只创建一个实例。
		解法一中的代码在单线程的时候工作正常，但在多线程的情况下就有 问题了。
		设想如果两个线程同时运行到判断instance是否为mill的if语句， 
		并且instance的确没有创建时，那么两个线程都会创建一个实例，
		此时类型 Singletonl就不再满足单例模式的要求了。
		为了保证在多线程环境下我们还 是只能得到类型的一个实例，需要加上一个同步锁。
	 */
	
	public synchronized SingletonDemo getSingleton2(){
		if(singleton==null){
			singleton=new SingletonDemo();
		}
		return singleton;
	}
	
	
	/**
	 * 假设有两个线程同时想创建一个实例。
	 * 由于在一个时刻只有 一个线程能得到同步锁，当第一个线程加上锁时，第二个线程只能等待。
	 * 当第一个线程发现实例还没有创建时，它创建出一个实例。
	 * 接着第一个线 程释放同步锁，此时第二个线程可以加上同步锁，并运行接下来的代码。
	 *  这时候由于实例己经被第一个线程创建出来了，第二个线程就不会重复创 建实例了，
	 *  这样就保证了我们在多线程环境中也只能得到一个实例。
	 *  但是类型Singleton2还不是很完美。我们每次通过属性Instance得到 Singleton2的实例，都会试图加上一个同步锁，
	 *  而加锁是一个非常耗时的操 作，在没有必要的时候我们应该尽量避免。
	 *  <♦可行的解法：加同步锁前后两次判断实例是否已存在我们只是在实例还没有创建之前需要加锁操作，
	 *  以保证只有一个线程 创建出实例。而当实例己经创建之后，我们己经不需要再执行加锁操作了。
	 * @param args
	 */
	
	public	SingletonDemo getSingleton3(){
		if(singleton==null){
			synchronized (singleton) {
				if(singleton==null){
					singleton=new SingletonDemo();
				}
			}
		}
		return singleton;
	}
	
}
