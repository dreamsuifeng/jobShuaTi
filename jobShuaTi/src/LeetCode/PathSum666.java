package LeetCode;

import java.util.Arrays;

public class PathSum666 {
	public int pathSum(int[] nums) {
		int[] tree=new int[32];
		Arrays.fill(tree, -1);
		for (int i:nums){
			int leve=i/100;
			int xth=(i/10)%10;
			int val=i%10;
			int index=(int) (Math.pow(2, leve)-Math.pow(2, leve-1)-1)+xth;
			tree[index-1]=val;
			
		}
		int ans=0;
		for (int i=0;i<32;++i){
			if (tree[i]==-1) continue;
			if (i*2+1<32 && tree[i*2+1]!=-1){
				tree[i*2+1]+=tree[i];
			}
			if (i*2+2<32 && tree[i*2+2]!=-1){
				tree[i*2+2]+=tree[i];
			}
			if ((i*2+1>=32 || tree[i*2+1]==-1) && (i*2+2>=32 || tree[i*2+2]==-1)){
				ans+=tree[i];
			}
		}
		return ans;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
