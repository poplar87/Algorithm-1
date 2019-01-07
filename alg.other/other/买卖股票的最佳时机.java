package other;
/** 
 *@author liujun
 *@date： 2018-12-17 下午05:30:46
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 *设计一个算法来计算你所能获取的最大利润。注意你不能在买入股票前卖出股票。
 *@URL:https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 *@version 1.0
 */
public class 买卖股票的最佳时机 {

	//只允许买卖一次股票
	public int justAllowOnce(int[] array) {

		int maxprofit = 0;
		int minfrice = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if(minfrice > array[i]){
				minfrice = array[i];
			}
			if(array[i] - minfrice > maxprofit){
				maxprofit = array[i] - minfrice;
			}
		}
		return maxprofit;
	}
	
	//允许买卖多次股票
	private int allowMany(int[] prices) {
		
		int peak = 0;
		int valley = Integer.MAX_VALUE;
		int count = 0;
		int flag = 0;
		while(flag < prices.length){
			//波谷判断
			while(flag < prices.length && prices[flag] < valley){
				valley = prices[flag];
				peak = prices[flag];
				flag++;
			}
			//波峰判断
			while(flag < prices.length && prices[flag] > peak){
				peak = prices[flag];
				flag++;
			}
			count += (peak - valley);
			//刷新波峰波谷
			peak = 0;
			valley = Integer.MAX_VALUE;
		}
		return count;
	}
	
	//test
	public static void main(String[] args) {
	
		int[] prices = {1,2,3,4,5,6,7};
		买卖股票的最佳时机 h = new 买卖股票的最佳时机();
		System.out.println(h.allowMany(prices));
	}
}
