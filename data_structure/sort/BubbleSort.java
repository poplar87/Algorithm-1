package sort;

/** 
 *@author liujun
 *@date： 2018-7-19 上午11:55:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:冒泡排序
 *@version 1.0
 */

public class BubbleSort {

	public int [] Bubble_sort(int [] sort_num) {//参数：int类型数组，对数组进行排序
		
		//交换变量：temp
		int temp = 0;
		
		//外部循环：循环元素个数减一次，因为最后一次默认有序
		for (int i = 0; i < sort_num.length-1; i++) {
			//内部循环：外部循环i次，可以确定i个元素已经有序，因此剩余n-i个无序元素，
			//内部循环次数为元素个数n减去外部循环次数i,又因为i和i+1对比，因此防止的对比越界，需再减一
			for (int j = 0; j < sort_num.length-i-1; j++) {
				
				if(sort_num[j] > sort_num[j+1]){
					temp = sort_num[j];
					sort_num[j] = sort_num[j+1];
					sort_num[j+1] = temp;
				}
			}
		}
		
		return sort_num;
	}
}
