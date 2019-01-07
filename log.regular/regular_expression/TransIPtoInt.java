package regular_expression;

import java.util.Scanner;

/** 
 *@author liujun
 *@date： 2018-8-28 下午02:14:14
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:将string类型的IP地址转化成int
 *@version 1.0
 */
public class TransIPtoInt {

	public int iPToInt(String ip) throws Exception {

		//正则表达式对IP进行判断
		ip = ip.trim();
		String regular = "^[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}$";
		if(!ip.matches(regular)){
			throw new Exception("IP地址有误！");
		}
		//IP转化为int
		int hex = 8;
		int ipnum = 0; 
		//如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");
		String[] iparray = ip.split("\\.");
		for (int i = 0; i < iparray.length; i++) {
			if(Integer.parseInt(iparray[i]) > 255){
				throw new Exception("IP地址超过255");
			}
			int f = Integer.parseInt(iparray[i]);
			f = f << (iparray.length - i - 1) * hex;
			ipnum += f;
		}
		return ipnum;
	}
	
	//int数转IP
	public String intToIP(int ipnum) {

		String intnum = "";
		int hex = 8; 
		int count = 1;
		for (int j = 3; j > 0; j--) {
			intnum += ipnum / ((count << (hex * j)) - 1);
			ipnum %= count << (hex * j);
			intnum += ".";
		}
		return intnum += ipnum;
	}
	
	//主方法测试
	public static void main(String[] args) throws Exception {
		
		String ip = "0.256.1.53";
		Scanner scan = new Scanner(System.in);
		ip = scan.nextLine();
		TransIPtoInt tp = new TransIPtoInt();
		int ipnum = tp.iPToInt(ip);
		System.out.println(ipnum);
		
		System.out.println(tp.intToIP(ipnum));;
		
	}
}
