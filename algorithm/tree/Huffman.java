package tree;
/** 
 *@author liujun
 *@date： 2018-8-27 下午09:37:31
 *@author—Email:ljfirst@mail.ustc.edu.cn
 *@description:将数组转化为赫夫曼树。
 *@version 1.0
 */
public class Huffman {

	//权值和指针域
	int weight;
	int left,right,parent;
	
	public Huffman[] buildHuffman(int[] array) {
		
		//构建Huffman数组并初始化
		Huffman[] root = new Huffman[2 * array.length - 1];
		//初始化
		for (int i = 0; i < 2 * array.length - 1; i++) {
			root[i] = new Huffman();
			root[i].left = root[i].right = root[i].parent = -1;
			if (i < array.length) {
				root[i].weight = array[i];
			}
		}
		//寻找最小值和次小值，并构建关系
		int min = 0;
		int minsecond = 0;
		int min_flag = 0;
		int minsecond_flag = 0;
		//注意：j < array.length - 1，遍历时为了构建n-1个非叶子结点。
		//分清array数组和root数组
		for (int j = 0; j < array.length - 1; j++) {
			//每次都需要重新赋值
			min = Integer.MAX_VALUE;
			minsecond = Integer.MAX_VALUE;
			//寻找最小值和次小值
			for (int k = 0; k < array.length + j; k++) {
				if (min > root[k].weight && root[k].parent == -1) {
					minsecond_flag = min_flag;
					min_flag = k;
					minsecond = min;
					min = root[k].weight;
				}else if (minsecond > root[k].weight && root[k].parent == -1) {
					minsecond_flag = k;
					minsecond = root[k].weight;
				}
			}
			//构建关系
			root[array.length + j].weight = minsecond + min;
			root[array.length + j].left = min_flag;
			root[array.length + j].right = minsecond_flag;
			root[min_flag].parent = array.length + j;
			root[minsecond_flag].parent = array.length + j;
		}
		return root;
	}
	
	public void printHuffman(Huffman[] root) {
		// TODO Auto-generated method stub

		int findnum = 0;
		int findparent = -1;
		//打印根节点
		for (int g = 0; g < root.length; g++) {
			if (root[g].parent == findparent) {
				System.out.print(root[g].weight + " ");
				findnum++;
				findparent = g;
			}
		}
	}
	//主方法测试
	public static void main(String[] args) {
		int[] array = {1,48,17,65,42,34,44,16,41,5};
		Huffman huf = new Huffman();
		//huf.buildHuffmanArray(array);
		huf.printHuffman(huf.buildHuffman(array));
	}
}
