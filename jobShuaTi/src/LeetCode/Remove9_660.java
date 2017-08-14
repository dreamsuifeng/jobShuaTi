package LeetCode;

public class Remove9_660 {
	public int newInteger(int n) {
		return Integer.parseInt(Integer.toString(n, 9));
        }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove9_660 t=new Remove9_660();
		System.out.println(t.newInteger((int)2E8));
	}

}
