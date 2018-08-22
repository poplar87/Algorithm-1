package link_list;

import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date： 2018-8-18 上午01:08:11
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:单链表
 *1. 单链表的头插法和尾插法
 *2. 单链表逆置
 *  2.1 数组存放，倒序输出
 *  2.2 利用栈倒叙输出(递归)
 *  2.3 反置链表，然后输出(非递归)
 *  2.4 反置链表，然后输出(递归)
 *@version 1.0
 */
public class SinglyLinkedList {

	int value;
	SinglyLinkedList next = null;
	
	public SinglyLinkedList() {
		// TODO Auto-generated constructor stub
		this.value = 0;
	}
	
	public SinglyLinkedList(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	//单链表——头插法
	public SinglyLinkedList insertHead(int[] list) {
		// TODO Auto-generated method stub
		//单链表表首结点-头插法,赋值
		System.out.println("单链表——头插法");
		SinglyLinkedList first = null;
		for (int i = 0; i < list.length; i++) {
			SinglyLinkedList link = new SinglyLinkedList(list[i]);
			link.next = first;
			first = link;
		}
		return first;
	}
	
	//单链表——尾插法
	public SinglyLinkedList insertTail(int[] list) {
		System.out.println("单链表——尾插法");
		// TODO Auto-generated method stub
		SinglyLinkedList point = null;
		SinglyLinkedList first = point;
		//循环赋值
		for (int i = 0; i < list.length; i++) {
			//尾插法
			SinglyLinkedList link = new SinglyLinkedList(list[i]);
			//首次判断
			if (first == null) {
				first = point = link;
			}
			point.next = link;
			point = point.next;
		}
		return first;
	}
	 //2. 单链表逆置
	 //  2.1 数组存放，倒序输出
	/*public void arrayReverse(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		System.out.println("数组存放，倒序输出");
		int[] array = new int[16];
		int count = 0;
		int max = 16;
		while (first != null) {
			array[count] = first.value;
			count++;
			//处理数组越界问题
			if(count == max){
				int[] arraycopy = new int[max * 2];
				for (int i : array) {
					
				}
			}
		}
	}*/
	
	 //  2.2 利用栈倒叙输出(递归)
	public void stackReverse(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		//System.out.println("利用栈倒叙输出(递归)");
		if(first.next != null){
			stackReverse(first.next);
		}
		System.out.print(first.value);
	}
	
	 //  2.3 反置链表，然后输出(非递归)
	public SinglyLinkedList listReverse(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		System.out.println("反置链表，然后输出(非递归)");
		SinglyLinkedList head = null;
		SinglyLinkedList p = null;
		while (first != null) {
			p = first;
			first = first.next;
			p.next = head;
			head = p;
		}
		return head;
	}
	
	
	 //  2.4 反置链表，然后输出(递归)
	public SinglyLinkedList listReverseRecursion(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		if(first == null || first.next == null){
			return first;
		}
		SinglyLinkedList newhead = listReverseRecursion(first.next);
		first.next.next = first;
		first.next = null;
		return newhead;
	}
	
	//输出链表
	public void printLink(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		while (first != null) {
			System.out.print(first.value + " ");
			first = first.next;
		}
	}
	
	//主方法测试
	public static void main(String[] args) {
//		Map  s = new HashMap<Integer, Integer>(12);
		//first是表头结点(含值0，后续被替换)
		SinglyLinkedList first = new SinglyLinkedList(0);
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		first = first.insertTail(array);
		first.printLink(first);
		System.out.println();
		first = first.listReverseRecursion(first);
		first.printLink(first);
	}
}
