package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 
 *@author liujun
 *@date£º 2018-8-23 ÏÂÎç10:12:46
 *@author¡ªEmail:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class fsef {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(8);
		list.add(9);
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 0){
				list.remove(i);
				//i--;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
}
