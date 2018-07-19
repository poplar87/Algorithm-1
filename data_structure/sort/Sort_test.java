package sort;
/** 
 *@author liujun
 *@date： 2018-7-19 下午01:16:13
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class Sort_test {

	public static void main(String[] args) {
		
		//测试数据，期望输出：123456789
		int [] sort_num = {8,2,4,6,5,7,9,1,3};
		
		//测试冒泡排序
		Bubble_sort b = new Bubble_sort();
		sort_num = b.Bubble_sort(sort_num);
		
		//输出数组
		for (int i = 0; i < sort_num.length; i++) {
			System.out.print(sort_num[i]+" ");
		}
	}
}
