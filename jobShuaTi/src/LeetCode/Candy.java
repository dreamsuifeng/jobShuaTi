package LeetCode;

public class Candy {
	public static int candy(int[] ratings) {
		if (ratings==null || ratings.length==0){
			return 0;
		}
        int n=ratings.length;
        int[] pre=new int[n];
        int[] post=new int[n];
        pre[0]=1;
        post[n-1]=1;
        for (int i=1;i<n;++i){
        	if (ratings[i]>ratings[i-1]){
        		pre[i]=pre[i-1]+1;
        	}else{
        		pre[i]=1;
        	}
        	if (ratings[n-i-1]>ratings[n-i]){
        		post[n-i-1]=post[n-i]+1;
        	}else {
				post[n-i-1]=1;
			}
        }
        int res=0;
        for (int j=0;j<n;++j){
        	res+=Math.max(pre[j], post[j]);
        }
        return res;
    }
	public static void main(String[] args){
		System.out.println(candy(new int[]{1,2,3,2,1,4,3}));
	}
}
