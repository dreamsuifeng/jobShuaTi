package XiaoZhao;

public class test32_1 {
	static int solve(int a,int b){
		while (a+b>0){
			a++;
			b--;
		}
		return a+b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(1, 0));
	}

}
