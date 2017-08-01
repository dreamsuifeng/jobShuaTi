package hihoCoder;

public class unionSet {
	private int[] pre;
	public unionSet(int n){
		pre=new int[n];
	}
	public int find(int x){
		int r=x;
		while (pre[r]!=r){
			r=pre[r];
		}
		int i=x,j;
		while (i!=r){
			j=pre[i];
			pre[i]=r;
			i=j;
		}
		return r;
	}
	
	public void join(int x, int y){
		int fx=find(x);
		int fy=find(y);
		if (fx!=fy){
			pre[fx]=fy;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
