package LeetCode;

public class ConstructtheRectangle492 {
	public int[] constructRectangle(int area) {
        int[] res=new int[2];
        int L=(int) Math.sqrt(area);
        if (L*L==area){
        	res[0]=L;
        	res[1]=L;
        }else{
        	for (int i=L+1;i<=area;++i){
        		if (area%i==0){
        			res[0]=i;
        			res[1]=area/i;
        			break;
        		}
        	}
        }
        return res;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
