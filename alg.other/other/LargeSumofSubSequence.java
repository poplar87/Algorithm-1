package other;
/** 
 *@author liujun
 *@date： 2018-7-20 下午02:08:03
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:已知数组A[1..n]中存放着一些实数，有正有负，
 *请写程序找出其最大求和子区间
 *@version 1.0
 */
public class LargeSumofSubSequence {

	//输入序列数组，输出最大子段和、起始地址、结束地址
	public LargeSumofSubSequence(int [] Sequence){
		
		int begin = 0;      //最大字段和的起始地址
		int temp_begin = 0; //假设的最大值
		int end = 0;        //最大字段和的结束地址
		int temp_sum = 0;  //暂时的最大值
		int sum = 0;       //记录最大值

		for(int i = 0; i < Sequence.length; i++){
			temp_sum += Sequence[i];
			if(sum < temp_sum){
				sum = temp_sum;   //记录最大值
				begin = temp_begin; //假定的起始地址赋值给起始地址
				end = i;
			}
			if(temp_sum <= 0){
				temp_sum = 0;      //sum清空
				temp_begin = i+1;   //假定的起始位置
			}
		}
		System.out.println("子序列最大值："+sum+" \n"+"子序列起始位置："
				+(begin+1)+" \n"+"子序列结束位置："+(end+1));
	}
	
	public static void main(String[] args) {
		
		/*int A[]={27,-49,1,3,-6,8,12,-5,-6,78,2,-6,-2,15,47,
				1,5,-69,52,5,51,-48,1,56,-19,-8,48,15};*/
		int B[]={-1,-2,-3,4,5,6,7,8,9,-10,-11,-12};
		
		new LargeSumofSubSequence(B);
	}
}
