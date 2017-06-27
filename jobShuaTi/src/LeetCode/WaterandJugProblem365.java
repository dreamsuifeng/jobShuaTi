package LeetCode;

public class WaterandJugProblem365 {
	public int GCD(int a, int b){
	    while(b != 0 ){
	        int temp = b;
	        b = a%b;
	        a = temp;
	    }
	    return a;
	}
	public boolean canMeasureWater(int x, int y, int z) {
		if(x + y < z) return false;
	    //case x or y is zero
	    if( x == z || y == z || x + y == z ) return true;
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z%GCD(x, y) == 0;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(0x5f375a86);
	}

}
