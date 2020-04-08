package Sort;

import java.util.HashMap;

import org.junit.Test;

public class ArrayRemoveDuplicates {

	/**
	 * 题目：
	 * 找出数组中重复的数字
	 * 在一个长度为n的数组里的所有数字都在0〜n-1的范围内。
	 * 数组中某 些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了 几次。
	 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数 组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
	 */
	
	/**
	 * 解法一：快速排序+遍历一次数组    时间复杂度O（nlogn)
	 * @return
	 */
	public void duplicate(){
		int a[]={2,3,1,0,2,5,3};
		//快速排序
		int[] b = quickSort(a, 0, a.length-1);
		//用作防止a[i+1]最终会数组越界的判断
		int j=0;
		for(int i=0;i<b.length;i++){
			if(++j<b.length){
				if(a[i]==a[i+1]){
					System.out.println(a[i]);
				}
			}
			
		}
	}
	//快排
	public int[] quickSort(int a[],int low,int high){
		if(low<high){
			int pivot=partition(a, low, high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
		return a;
	}
	
	public int partition(int a[],int low,int high){
		//选择第一个值作为基准
		int pivot=a[low];
		while(low<high){
			//小于基准的数往左[low]放，大于基准的数往右[high]放
			while(low<high&&pivot<=a[high]){
				high--;
			}
			a[low]=a[high];
			while(low<high&&pivot>=a[low]){
				low++;
			}
			a[high]=a[low];
		}
		//多出一个空位在[low]位，放回基准数
		a[low]=pivot;
		//放回基准的位置
		return low;
	}
	
	/**
	 * 解法二：
	 * 利用哈希表来解决这个问题。
	 * 从头到尾按顺序扫描数组的每个 数字，每扫描到一个数字的时候，
	 * 都可以用0(1)的时间来判断哈希表里是 否已经包含了该数字。
	 * 如果哈希表里还没有这个数字，就把它加入哈希表。 
	 * 如果哈希表里已经存在该数字，就找到一个重复的数字。
	 * 
	 * 时间 复杂度是0(n),但它提高时间效率是以一个大小为0(n)的哈希表为代价的.
	 */
	
	public void duplicate2(){
		int a[]={2,3,1,0,2,5,3};
		HashMap<Object, Object> hashmap=new HashMap<>();
			for(int i=0;i<a.length;i++){
				if(!hashmap.get(a[i]).equals(a[i])){
					//表明数字没重复，放入值
					hashmap.put(a[i], a[i]);
				}else{
					System.out.println(a[i]);
				}
		}
	}
	
	
	/**
	 * 解法三
	 * 我们注意到数组中的数字都在0〜n-1的范围内。
	 * 如果这个数组中没有 重复的数字，那么当数组排序之后数字i将出现在下标为i的位置。
	 * 由于数 组中有重复的数字，有些位置可能存在多个数字，同时有些位置可能没有 数字。
	 * 
	 * 现在让我们重排这个数组。
	 * 从头到尾依次扫描这个数组中的每个数字。 
	 * 当扫描到下标为i的数字m时，首先比较m是不是等于i。 
	 * 如果是，则接着扫描下一个数字；
	 * 如果不是，则再拿它和第m个数字进行 比较。如果它和第个数字相等，就找到了一个重复的数字（该数字在下 标为i和m的位置都出现了）；
	 * 如果它和第m个数字不相等，就把第i个数 字和第m个数字交换，把m放到属于它的位置。接下来再重复这个比较、 交换的过程，直到我们发现一个重复的数字。
	 * 以数组{2,3,1,0,2,5,3}为例来分析找到重复数字的步骤。
	 * 数组的第0个数字（从0开始计数，和数组的下标保持一致）是2,与它的下标不相等， 于是把它和下标为2的数字1交换。
	 * 交换之后的数组是{1，3, 2, 0, 2, 5, 3}。 此时第0个数字是1，仍然与它的下标不相等，继续把它和下标为1的数字 3交换，得到数组{3, 1，2, 0, 2, 5, 3}。
	 * 接下来继续交换第0个数字3和第3 个数字0,得到数组{0, 1,2, 3, 2, 5, 3}。此时第0个数字的数值为0,接着 扫描下一个数字。在接下来的几个数字中，下标为1、2、3的3个数字分 别为1、2、3,它们的下标和数值都分别相等，因此不需要执行任何操作。
	 * 接下来扫描到下标为4的数字2。由于它的数值与它的下标不相等，再比较 它和下标为2的数字。注意到此时数组中下标为2的数字也是2,也就是 数字2在下标为2和下标为4的两个位置都出现了，因此找到一个重复的 数字。

	 * 
	 * 时间复杂度O（n）,空间复杂度O（1）
	 */
	public boolean duplicate3(){
		int a[]={2,3,1,0,2,5,3};
		
		for(int i=0;i<a.length;i++){
			//当扫描到下标为i的值m不等于i 
			//重复从某个位置开始直到这个位置的值与下标一致。
			while(a[i]!=i){
				//如果相等，则说明有该值重复
				if(a[a[i]]==a[i]){
					System.out.println("找到重复的数字"+a[i]);
					break;
				}
				//如果不等，则交换位置
				int temp=a[i];
				a[i]=a[temp];
				a[temp]=temp;
			}
		}
		return false;
	}
	/**
	 * 代码中尽管有一个两重循环，但每个数字最多只要交换两次就能找到 属于它自己的位置，
	 * 因此总的时间复杂度是〇(n)。另外，所有的操作步骤 都是在输入数组上进行的，不需要额外分配内存，因此空间复杂度为0(1)。
	 */
	
	
	
	
	@Test
	public void test() {
		duplicate3();
	}
	
	
	

}
