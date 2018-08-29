package tree;

import java.util.HashMap;
import java.util.Map;

/** 
 *@author liujun
 *@date： 2018-8-29 下午10:29:42
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:红黑树
 *包括方法：containsKey(), get(), put(), remove()。
 *本文只处理int类型值的红黑树。
 *@version 1.0
 */
public class RedBlackTree {

	int value;
	RedBlackTree left;
	RedBlackTree right;
	RedBlackTree parent;
	String color ;
	
	//构造函数
	public RedBlackTree() {
		// TODO Auto-generated constructor stub
		int value = -1;
		color = "RED";
	}
	
	public RedBlackTree(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		color = "RED";
	}

	//右旋函数,注意：右旋使用当且仅当结点的左孩子存在时，因此，不需要对point.right进行判断。
	private void rotateRight(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pleft = point.left;
		//处理point左孩子的右孩子问题
		point.right = pleft.left;
		if (null != pleft.right) {
			pleft.right.parent = point;
		}
		//处理point的父节点问题
		pleft.parent = point.parent;
		if (null != point.parent) {
			root = pleft;
		}else if(point.parent.left == point){
			point.parent.left = pleft;
		}else {
			point.parent.right = pleft;
		}
		//处理point自身问题
		pleft.right = point;
		point.parent = pleft;
	}
	
	//左旋函数,注意：左旋使用当且仅当结点的右孩子存在时，因此，不需要对point.right进行判断。
	private void rotateLeft(RedBlackTree root, RedBlackTree point) {

		RedBlackTree pright = point.right;
		//处理point右孩子的左孩子问题
		point.right = pright.left;
		if (null != pright.left) {
			pright.left.parent = point;
		}
		//处理point的父节点问题
		pright.parent = point.parent;
		if (null != point.parent) {
			root = pright;
		}else if(point.parent.left == point){
			point.parent.left = pright;
		}else {
			point.parent.right = pright;
		}
		//处理point自身问题
		pright.left = point;
		point.parent = pright;
	}
	
	//放入元素
	public void add(RedBlackTree root, int value) {

		//init
		if (-1 == root.value) {
			root = new RedBlackTree(value);
			root.color = "BLACK";
			return;
		}
		RedBlackTree point = new RedBlackTree(value);
		RedBlackTree search = root;
		RedBlackTree search_bef = root;
		//寻找插入点
		while (search != null) {
			search_bef = search;
			if (search.value < value) {
				search = search.right;
			}else {
				search = search.left;
			}
		}
		//结点插入
		point.parent = search_bef;
		if (search_bef.value < value) {
			search_bef.right = point;
		}else {
			search_bef.left = point;
		}
		// 每次插入进行结点调整,此处仅对point.paren进行判断，后续判断在insertFixup中进行?
		if (null != point.parent) {
				insertFixup(root, point);
			}
		}
		
	
	//调整红黑树的颜色：红叔问题和黑叔问题，其中黑叔问题继续分为左右孩子问题
	public void insertFixup(RedBlackTree root, RedBlackTree point) {

		RedBlackTree uncle;
		//父节点是红色
		while (null != point.parent && "RED".equals(point.parent.color)) {
			//父节点位置。问题一：为什么“祖父节点”之前是黑色？
			//这个应该很容易想明白，因为在变换操作之前，该树是红黑树，“父节点”是红色,那么“祖父节点”一定是黑色。
			//问题二：为什么将“祖父节点”由“黑色”变成红色，同时，将“叔叔节点”由“红色”变成“黑色”？
			//能解决“包含“父节点”和“叔叔节点”的分支的黑色节点的总数增加了1”的问题。
			if (root == point.parent) {
				root.color = "BLACK";
				return;
			}else {
				//else间接说明point.parent.parent！=null
				//红黑叔问题
				uncle = point.parent == point.parent.parent.left ? 
						point.parent.parent.right : point.parent.parent.left;
				//因为空指针的颜色默认是黑色，所以先解决黑叔问题
				if (null == uncle || "BLACK".equals(uncle.color)) {
					//黑叔问题:左孩子问题
					//(01) 将“父节点”设为“黑色”。(02) 将“祖父节点”设为“红色”。(03) 以“祖父节点”为支点进行右旋。
					//(01)避免了两个红结点，(02)避免了经过父节点分支的黑色节点的个数增加了1
					//(03)避免了经过uncle分支的黑色节点的个数增加了1
					if (point == point.parent.left) {
						point.parent.color = "BLACK";
						point.parent.parent.color = "RED";
						//此处右旋跟左右孩子无关，仅跟(03)相关
						rotateRight(root, point.parent.parent);
						
					//黑叔问题:右孩子问题
					}else {
						
					}
				//红叔问题
				}else {
					uncle.color = "BLACK";
					point.parent.color = "BLACK";
					point.parent.parent.color = "RED";
					point = point.parent.parent;
					if (root == point) {
						root.color = "BLACK";
						return;
					}
				}
			}
		}
		
	}
	
	//元素检查
	public boolean containsKey(int value) {

		
		return false;
	}
	
	//移除元素
	public void remove() {

	}
	
	//中序输出红黑树，从小到大
	public void print(RedBlackTree root) {

		if (null == root) {
			return;
		}
		print(root.left);
		System.out.print(root.value + " ");
		print(root.right);
	}
	
	//主方法测试
	public static void main(String[] args) {
		RedBlackTree root = new RedBlackTree();
		int[] array = {45,4,94,65,19,4,13,46,51,6,54};
		for (int i = 0; i < array.length; i++) {
			root.add(root, array[i]);
		}
		System.out.println(root.containsKey(45));
		root.print(root);
		//Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	}
}
