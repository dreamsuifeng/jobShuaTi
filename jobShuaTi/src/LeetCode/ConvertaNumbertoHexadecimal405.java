package LeetCode;
public class ConvertaNumbertoHexadecimal405 {
	public static String toHex(int num) {
		return Integer.toHexString(num);
	}
	public String toHex1(int num) {
        if(num==0) return "0";
        char[] map=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; 
        int mask = 15; //0x0000000f
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            sb.append(map[num & mask]);
            num=num>>>4;
        }
        sb.reverse();
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toHex(0));
	}

}
