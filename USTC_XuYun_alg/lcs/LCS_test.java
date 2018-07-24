package lcs;

import java.util.Random;

public class LCS_test {

	//生成一组包含大小写，数字的序列
	public String random_sequence() {
		
		Random ran=new Random();
		String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//生成序列长度值,小于20
		int n=ran.nextInt(20)+1;//Random.nextInt(int n),该值介于[0,n)的区间，包含0而不包含n。
		//字符串序列
		String  s="";
		
		//随机生成“大写字母”、“小写字母”、“数字”
		int m=0;//m取值1，2，3，表示选择“大写字母”、“小写字母”、“数字”
		while(n>0){
			m=ran.nextInt(3);
			switch(m){
			  case 0:
				  int y=ran.nextInt(26);
				  s+=alpha.subSequence(y, y+1);
				  break;
			  case 1:
				  int h=ran.nextInt(26);
				  CharSequence g=alpha.subSequence(h, h+1);
				  s+=g.toString().toLowerCase();
				  break;
			  case 2:s+=ran.nextInt(10);
				  break;
			  default:
				  break;
			}
			n--;
		}
		//输出随机字符串
		return s;
	}
	
	public static void main(String[] args) {
		
		//获取随机字符串
		LCS_test lt = new LCS_test();
		String s1 = lt.random_sequence();
		String s2 = lt.random_sequence();
		System.out.println("字符串s1:"+ s1);
		System.out.println("字符串s2:"+ s2);
		
		//字符串匹配
		LCS lcs = new LCS(s1, s2);
		//System.out.println("======================");
		new LCS_optimize(s1, s2);
		
	}
}
