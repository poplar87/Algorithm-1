package sort;
/** 
 *@author liujun
 *@date： 2018-7-19 下午01:16:13
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class SortTest {

	public static void main(String[] args) {
		
		//测试数据，期望输出：123456789
		int [] sort_num = {8,2,4,6,5,7,9,1,3};
		//int [] sort_num = {1,1,2,2,2,2,5,5,5,5,2,2,2};
		
		//测试冒泡排序
		//Bubble_sort b = new Bubble_sort();
		//sort_num = b.Bubble_sort(sort_num);
		
		//选择排序
		//Selection_sort sel = new Selection_sort();
		//sort_num = sel.Selection_sort(sort_num);
		
		//插入排序测试
		//Insertion_sort ins = new Insertion_sort();
		//sort_num = ins.Insertion_sort(sort_num);
		
		//快速排序测试
		QuickSort quick_s = new QuickSort();
		//quick_s.Quick_sort_Simplex(sort_num, 0, sort_num.length-1);
		quick_s.Quick_sort_duplexing(sort_num, 0, sort_num.length-1);
		
		//堆排序
		/*HeapSort hp = new HeapSort();
		hp.heapSort(sort_num);*/
		
		//输出数组
		for (int i = 0; i < sort_num.length; i++) {
			System.out.print(sort_num[i]+" ");
		}
	}
}
