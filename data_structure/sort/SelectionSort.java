package sort;

/** 
 *@author liujun
 *@date： 2018-7-19 上午11:55:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:选择排序
 *@version 1.0
 */

public class SelectionSort {

	public int [] Selection_sort(int [] sort_num) {
		// TODO Auto-generated constructor stub
		int length = sort_num.length;
		int temp = 0;
		int flag = 0;
		
		//外部循环从0到n-1
		for (int i = 0; i < length - 1; i++) {
			flag = i;//记录最值元素的下角标
			//从待交换元素的下一个开始查找，直到最后一个元素
			for (int j = i+1; j <= length - 1; j++) {
				if(sort_num[j] < sort_num[flag]){
					flag = j;
				}
			}
			//元素交换
			temp = sort_num[i];
			sort_num[i] = sort_num[flag];
			sort_num[flag] = temp;
		}
		return sort_num;
	}
}
