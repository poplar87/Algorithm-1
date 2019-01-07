package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-2 Time：下午09:34:09
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:计算字符串最后一个单词的长度，单词以空格隔开。
 *@version 1.0
 */
public class 统计最后一个单词长度 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String string = scan.nextLine();
			//从安全角度考虑，加trim()防止前后出现多个空格
			System.out.println(string.trim().length() - 
					string.trim().lastIndexOf(" ") - 1);
		}
	}
}
