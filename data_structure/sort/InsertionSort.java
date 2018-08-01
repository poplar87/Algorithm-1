package sort;

/** 
 *@author liujun
 *@date： 2018-7-19 上午11:55:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:插入排序
 *@version 1.0
 */

public class InsertionSort {

	public int [] Insertion_sort(int [] sort_num) {
		// TODO Auto-generated constructor stub
		int temp = 0;
		
		//外部循环从1开始，直到最后
		for (int i = 1; i < sort_num.length; i++) {
			//内部循环从外部位置遍历到0
			for (int j = i; j > 0; j--) {
				if(sort_num[j] < sort_num[j - 1]){
					temp = sort_num[j];
					sort_num[j] = sort_num[j - 1];
					sort_num[j - 1] = temp;
				}
			}
		}
		return sort_num;
	}
}
