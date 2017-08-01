package LeetCode;

public class NumberComplement476 {
	 public int findComplement(int num) {
	        String string=Integer.toBinaryString(num);
	        StringBuffer sBuffer=new StringBuffer();
	        for (char c:string.toCharArray()){
	        	if (c=='1'){
	        		sBuffer.append(0);
	        	}else{
	        		sBuffer.append(1);
	        	}
	        }
	        System.out.println(sBuffer.toString());
	        return Integer.parseInt(sBuffer.toString(), 2);
	    }
}
