package other;

/** 
 *@author liujun
 *@date： 2018-7-19 下午08:41:46
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *例如，如果输入如下4*4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 *则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *@version 1.0
 */
public class 顺时针打印矩阵 {
	
	public 顺时针打印矩阵(){
		
	}
	
	public 顺时针打印矩阵(int [][] matrix){
		
		//获取矩阵的行、列、总数
		int row = matrix.length;
		int column = matrix[0].length;
		int count = row * column;
		
		while(count > 0){
			for (int i = 0; i < matrix[0].length; i++) {
				System.out.print(matrix[0][i]+" ");
				count--;
			}
			matrix = Matrix_transposed(matrix);
		}
	}
	
	//去除第一行之后，再进行矩阵转置
	public int [][] Matrix_transposed(int [][] matrix){
		
		//获取矩阵的行、列
		int row = matrix.length;
		int column = matrix[0].length;
		//新建一个转置数组，行数减一
		int [][] matrix_transposed = new int [column][row-1];
		for (int i = 1,h=0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix_transposed[column-j-1][h] = matrix[i][j];
			}
			h++;
		}
		/* 
		 * 输出测试
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row-1; j++) {
				System.out.print(matrix_transposed[i][j]+ " ");
			}
			System.out.println();
		}*/
		return matrix_transposed;
	}
	
	public static void main(String[] args) {
		
		int [][] matrix_a = {{1,5,7,6,9},{5,7,8,3,1},{2,4,8,6,1}}; 
		//int [][] matrix_b = {{5,7,6,3},{5,3,1,5},{2,4,1,3},{5,6,8,2},{8,3,1,1}};
	
		new 顺时针打印矩阵(matrix_a);
		//s.Matrix_transposed(matrix_a);
	}
}
