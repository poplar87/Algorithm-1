package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-13 Time：下午10:31:25
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:trans digital to capital
 *@version 1.0
 */
public class DigitalTrans {

	String[] digital = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	String[] element = {"元","拾","百","仟","万","拾","百","仟","亿"};
	
	public String trans(String num) throws Exception {
		
		//1.去空格
		num = num.trim();
		//2.数字判断： 2.1 除了一个小数点和多个数字，其他字符都不对。  
		//         2.2 以0开头的不正确(022,02.2)，除了0.x
		if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
			throw new Exception("钱数格式错误！");
		}
		
		//3.分成整数和小数部分处理
		//4.整数和小数部分合并，去零
		

		return num;
	}
	
	public static void main(String[] args) {

		while(true){
			Scanner scan = new Scanner(System.in);
			DigitalTrans dt = new DigitalTrans();
			try {
				System.out.println(dt.trans(scan.next()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
