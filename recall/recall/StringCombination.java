package recall;

/** 
 *@author liujun
 *@date： 2018-8-23 上午09:56:39
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:将输入字符串按照全排列的方式打印输出
 *@version 1.0
 *@attation:1.Java字符数组如何输出:2种方式。
 *          2.循环处i = depth
 */
public class StringCombination {

	//
	public void Permutation(char[] c, int depth) {
		// TODO Auto-generated method stub

		//边界值判断
		if (depth == c.length - 1) {
			//System.out.println(c);
			System.out.println(String.valueOf(c));
			return;
		}
		//注意：此处i = depth。i之前的元素已经有序，只对后续元素进行全排列
		for (int i = depth; i < c.length; i++) {
			//数组元素交换
			char ch_temp = c[i];
			c[i] = c[depth];
			c[depth] = ch_temp;
			Permutation(c, depth + 1);
		}
	}
	
	//主方法测试
	public static void main(String[] args) {
		String s = "ABCD";
		char[] c = s.toCharArray();
		StringCombination sc = new StringCombination();
		sc.Permutation(c, 0);
	}
}
