package regular_expression;

import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-13 Time：下午10:31:25
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:trans digital trans to capital
 *method:
 * 1.去空格.
   2.数字判断： 2.1 除了一个小数点和多个数字，其他字符都不对。  
            2.2 以0开头的不正确(022,02.2)，除了0.x
   3.分成整数和小数部分处理.
   4.整数和小数部分合并，去零.
 *@version 1.0
 */
public class DigitalTrans {

	String[] digital = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	String[] element = {"元","拾","百","仟","万","拾万","百万","仟万","亿"};
	String[] small = {"角","分","毫","厘"};
	
	public String trans(String num) throws Exception {
		
		//1.去空格
		num = num.trim();
		//2.数字判断:1)除了一个小数点和多个数字，其他字符都不对。2)以0开头的不正确(022,02.2)，除了0.x
		if (!num.matches("[0-9]|^[1-9]+[0-9]*$|^0\\.[0-9]+$|^[1-9]+[0-9]*\\.[0-9]+$")) {
			throw new Exception("钱数格式错误！");
		}
		//3.分成整数和小数部分处理——预处理
	    String[] deal = num.split("\\.");
	    //整数部分最多只保留九位，仅用于测试
	    String wholenum = deal[0];
	    if(deal[0].length() > 9){
	    	int k = deal[0].length() - 9;
	    	wholenum = deal[0].substring(k);
	    }
	    //3.分成整数和小数部分处理——处理
	    boolean flag = false;
	    StringBuffer sb = new StringBuffer();
	    int index = wholenum.length() - 1;
	    for (int i = 0; i <= wholenum.length() - 1; i++) {
	    	//遇见0进行和合并操作
	    	if(flag && wholenum.charAt(i) == '0'){
				
	    	}else if(wholenum.charAt(i) == '0'){
	    		sb.append("零");
				flag = true;
				}else{
					sb.append(digital[Integer.parseInt(wholenum.charAt(i)+"")]+element[index]);
					flag = false;
				}
			index--;
		}
	    //如果整数以零结尾，则替换成元
	    if(sb.lastIndexOf("零") == sb.length() - 1){
	    	sb.replace(sb.length() - 1, sb.length(), "元");
	    }
	    //如果整数部分仅包括零，如0.1，则直接去掉(因为仅包括零的被替换成元，所以以元作为匹配)
	    if(sb.toString().equals("元")){
	    	sb = new StringBuffer();
	    }
	    //如果包含小数
	    if(deal.length > 1){
	    	//小数部分最多只保留小数点后四位，仅用于测试
		    String decimal = deal[1];
		    if(deal[1].length() > 4){
		    	decimal = deal[1].substring(0, 4);
		    }
		    index = 0;
		    flag = false;
		    for (int i = 0; i <= decimal.length() - 1; i++) {
		    	//遇见0进行和合并操作
		    	if(flag && decimal.charAt(i) == '0'){
					
		    	}else if(decimal.charAt(i) == '0'){
		    		sb.append("零");
					flag = true;
					}else{
						sb.append(digital[Integer.parseInt(decimal.charAt(i)+"")]+small[index]);
						flag = false;
					}
				index++;
			}
		    //如果小数以零结尾，则直接去掉
		    if(sb.lastIndexOf("零") == sb.length() - 1){
		    	sb.replace(sb.length() - 1, sb.length(), "");
		    }
	    }
		//4.整数和小数部分合并，去零
		return sb.toString();
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
