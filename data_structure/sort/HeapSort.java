package sort;

/** 
 *@author liujun
 *@date： 2018-7-19 上午11:55:48
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:堆排序，初始化建堆的时间复杂度为O(n)，
 *排序重建堆的时间复杂度为nlog(n)，所以总的时间复杂度为O(n+nlogn)=O(nlogn)。
 *思路：
 *1)初试化建堆，堆顶即最大元素。
 *2)交换堆顶和数组末尾元素，然后针对剩余的n-1个元素，对堆顶元素进行调整即可，
 *3)重复2),直到所有元素有序。
 *如何将数组调整为大顶堆
 *  1、初始化建堆只需要对二叉树的非叶子节点调用，从数组二分之n处分别跟左右孩子对比，
 *发生交换，交换后的孩子，进一步跟它的左右孩子发生对比，直到数组对比达到边界,
 *至此，二分之n这个二叉树有序(大顶堆)。O(n)
 *  2、不断缩小范围，自底向上，从右到左，从二分之n循环到顶(1)，至此，整个数组/二叉树有序(大顶堆)。
 *@version 1.0
 */

public class HeapSort {

	public void heapSort(int [] heap) {
		//输入检查
		if (heap == null || heap.length <= 1) {  
            return;  
        }
		
		//初试化建堆
		for (int i = (heap.length - 1) / 2; i >= 0 ; i--) {
			heapify(heap, i, heap.length - 1);
		}
		
		//交换堆顶和数组末尾元素，循环整堆,注意边界值
		for (int i = heap.length - 1; i > 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			heapify(heap, 0, i-1);
		}
	}
	
	//整堆函数
	public void heapify(int[] heap, int parent, int border){
		
		//左孩子，最大值标记
		int flag = parent * 2 + 1;
		//越界判断
		if(flag > border){
			return ;
		}
		//如果右孩子存在
		if(flag + 1 <= border){
			//左右孩子对比，找最大值
			flag = heap[flag] > heap[flag + 1] ? flag : flag + 1;
		}
		//对比父节点和孩子结点，找最大值,发生交换,并递归其最大值孩子结点
		if(heap[flag] > heap[parent]){
			int temp = heap[flag];
			heap[flag] = heap[parent];
			heap[parent] = temp;
			heapify(heap, flag, border);
		}
	}
}
