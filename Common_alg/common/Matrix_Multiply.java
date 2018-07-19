package common;
/** 
 *@author liujun
 *@date： 2018-7-19 下午03:07:41
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:
 *@version 1.0
 */
public class Matrix_Multiply {

	public Matrix_Multiply(int [][] materix_a, int [][] materix_b) {
		// TODO Auto-generated constructor stub
		
		//定义相乘后的矩阵
		//获取矩阵的行
		int row = materix_a.length;
		//获取矩阵的列
		int column = materix_b[0].length;
		int [][] materix_c = new int [row][column];
		
		//矩阵相乘
		//首先循环A矩阵的行,时间复杂度：O(materix_a.length)
		for (int i = 0; i < materix_a.length; i++) {
			//再循环B矩阵的列,时间复杂度：O(materix_b[0].length)
			for (int j = 0; j < materix_b[0].length; j++) {
				//A矩阵的行元素和B矩阵列元素逐个相乘,
				//注意materix_b.length=materix_a[0].length=materix_c[0].length
				for (int h = 0; h < materix_b.length; h++) {
					materix_c[i][j] += materix_a[i][h]*materix_b[h][j];
				}
			}
		}
		
		//打印输出c矩阵
		for (int i = 0; i < materix_c.length; i++) {
			for (int j = 0; j < materix_c[0].length; j++) {
				System.out.print(materix_c[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		//准备两个矩阵（二维数组）:a是3*5，b是5*4
		int [][] materix_a = {{1,5,7,6,9},{5,7,8,3,1},{2,4,8,6,1}}; 
		int [][] materix_b = {{5,7,6,3},{5,3,1,5},{2,4,1,3},{5,6,8,2},{8,3,1,1}};
		
		new Matrix_Multiply(materix_a, materix_b);
	}
}