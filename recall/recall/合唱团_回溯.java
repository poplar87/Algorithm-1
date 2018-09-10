package recall;


import java.util.Scanner;

/**
 *@author liujun
 *@date： 2018-5-2 Time：下午11:00:55
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n个学生中
 *按照顺序选取 k名学生，要求相邻两个学生的位置编号的差不超过 d，
 *使得这 k个学生的能力值的乘积最大，你能返回最大的乘积吗？
 *@version 1.0
 */
public class 合唱团_回溯 {

	//学生数量、学生能力值数组
	static int student_num ;
	static long [] student_power ;
	
	//筛选最佳值、记录最佳入选能力值和最佳能力序列
	static long sum_best = 1;
	static long [] student_chosed_power ;
	static long [] student_chosed_num ;
	
	//筛选暂时值，记录入选能力值和暂时能力序列
	static long sum_temp = 1;
	static long [] student_temp_power ;
	static long [] student_temp_num ;
	
	//挑选k个学生和设置d个间距
	static int k ,d ;
	
	//动态规划开始，定义递归深度、和暂时值
	static int depth = 0;
	
	//递归传入递归深度和轮到的学生编号
	public void digui (int depth, int start){
		//边界条件判断
		if (depth > k) {
			if(sum_temp > sum_best && distance(student_temp_num)){
				sum_best = sum_temp;
				for (int e = 0; e < student_temp_power.length; e++) {
					student_chosed_num[e] = student_temp_num[e];
					student_chosed_power[e] = student_temp_power[e];
				}
			}
			return ;
		}
		
		for (int j = start; j < student_num; j++) {
			if(student_power[j] == 0){
				continue;
			}
			sum_temp *= student_power[j];
			student_temp_power[depth] = student_power[j];
			student_temp_num[depth] = j;
			
			digui(depth+1, j+1);
			
			sum_temp /= student_power[j];
			student_temp_power[depth]= 0;
			student_temp_num[depth] = 0;
		}
		
		return;
	}
	
	public boolean distance(long [] student_chose_num){
		for (int u = 0; u < student_chose_num.length -1; u++) {
			if(student_chose_num[u+1] - student_chose_num[u] > d){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter student_num");
		student_num = scan.nextInt();
		student_power = new long [student_num];
		
		//能力值赋值
		System.out.println("enter several student_power");
		for (int i = 0; i < student_num; i++) {
			student_power[i] = scan.nextInt();
		}

		//获取k个学生和设置d个间距
		System.out.println("set k student");
		k = scan.nextInt();
		System.out.println("set d distance");
		d = scan.nextInt();
		
		//记录入选学生能力值和对应序号
		student_temp_power = new long[k];
		student_temp_num = new long[k];
		student_chosed_power = new long[k];
		student_chosed_num = new long[k];
		
		k--;
		
		new 合唱团_回溯().digui(0, 0);
		System.out.print(sum_best);
		
	}
	
}
