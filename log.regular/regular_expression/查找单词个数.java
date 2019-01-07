package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-2 Time：下午09:46:20
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:写出一个程序，接受一个有字母和数字以及空格组成的字符串，
 *和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *@version 1.0
 */
public class 查找单词个数 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//输入一个字符串
		String string = scan.nextLine();
		//输入一个单词
		String s = scan.next();
		System.out.println(string.toLowerCase().split(s).length-1);
	}
}
