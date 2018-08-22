package link_list;
/** 
 *@author liujun
 *@date： 2018-8-22 下午02:06:33
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *1. 判断单聊表是否有环
 *2. 找出带环单链表的入口
 *@version 1.0
 */
public class RangList extends SinglyLinkedList{

	public RangList(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	//尾插法改写为构造有环链表
	public SinglyLinkedList insertTail(int[] list) {
		System.out.println("尾插法改写为构造有环链表");
		SinglyLinkedList point = null;
		SinglyLinkedList first = point;
		//环入口结点
		SinglyLinkedList temp = new SinglyLinkedList();
		//尾插法，循环赋值
		for (int i = 0; i < list.length; i++) {
			SinglyLinkedList link = new SinglyLinkedList(list[i]);
			//首次判断
			if (first == null) {
				first = point = link;
			}
			//环入口结点
			if(i == list.length/2){
				temp = link;
				System.out.println("插入点："+temp.value);
			}
			point.next = link;
			point = point.next;
		}
		//为节点构造环
		point.next = temp;
		return first;
	}
             
	//判断单链表是否有环
	public boolean FindListTail(SinglyLinkedList first) {
		// TODO Auto-generated method stub
		SinglyLinkedList slow = first;
		SinglyLinkedList fast = first;
		
		while (fast.next != null && fast != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	//返回单链表环的相遇点
	public SinglyLinkedList ListMeet(SinglyLinkedList first) {
		
		SinglyLinkedList slow = first;
		SinglyLinkedList fast = first;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return fast;
			}
		}
		return null;
	}
	
	//找出带环单链表的入口
	public SinglyLinkedList findLoopPort(SinglyLinkedList first) {
		// TODO Auto-generated method stub

		SinglyLinkedList point_meet = ListMeet(first);
		while(first != null && point_meet != null){
			if(first == point_meet){
				return point_meet;
			}
			first = first.next;
			point_meet = point_meet.next;
		}
		return null;
	}
	
	//主方法测试
	public static void main(String[] args) {
		
		//构造有环单链表
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		RangList rl = new RangList(0);
		SinglyLinkedList first= rl.insertTail(array);
		
		//测试单链表是否有环
		System.out.println(rl.FindListTail(first));
		System.out.println(rl.ListMeet(first).value);
	}
}
