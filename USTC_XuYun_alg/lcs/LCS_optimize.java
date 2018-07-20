package lcs;
/** 
 *@author liujun
 *@date： 2018-7-19 上午10:52:22
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:lcs改进算法，只需一行数组即可以获取匹配数最大值，节省了空间，
 *但是无法获取匹配匹配的字符串。
 *@version 1.0
 */
public class LCS_optimize {

	public LCS_optimize(String s1, String s2){
		
		//获取字符串长度,其中在矩阵中n1表示行数,n2表示列数
		int n1 = s1.length();
		int n2 = s2.length();
		
		//数值矩阵 存放字符匹配数量的最大值
		int [] lcs_opt_matrix = new int [n2+1];
		//初始化数组
		lcs_opt_matrix[0] = 0;
		
		//temp用来保存上一次遍历时当前位的最大值
		int temp = 0;
		int temp1 = 0;
		//遍历匹配
		for (int i = 0; i < n1; i++) {
			for (int j = 1; j <= n2; j++) {
				temp1 = lcs_opt_matrix[j];
				
				if(s1.charAt(i) == s2.charAt(j-1)){
					lcs_opt_matrix[j] = temp + 1;
				}else {
					lcs_opt_matrix[j] = lcs_opt_matrix[j] > lcs_opt_matrix[j-1] ? 
							lcs_opt_matrix[j] : lcs_opt_matrix[j-1];
				}
				temp = temp1;
			}
		}
		//输出子字符匹配数量的最大值
		System.out.println("最大子字符串长度为："+lcs_opt_matrix[n2]);
	}
}
