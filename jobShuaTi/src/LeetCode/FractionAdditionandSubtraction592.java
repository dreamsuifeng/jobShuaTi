package LeetCode;

public class FractionAdditionandSubtraction592 {
	private int gcd(int a1,int a2){
		int m=Math.max(a1, a2);
		int n=Math.min(a1, a2);
		while (n!=0){
			int t=n;
			n=m%n;
			m=t;
		}
//		System.out.println(m);
		return m;
	}
	private String compute(String s1,String s2,String preflag){
		String[] ss1=s1.split("/");
		String[] ss2=s2.split("/");
		int a1=Integer.parseInt(ss1[1]), a2=Integer.parseInt(ss2[1]);
		int fenmuGcd=gcd(a1,a2);
		int fenmu=a1*a2/fenmuGcd;
		int c1=Integer.parseInt(ss1[0]);
		int c2=Integer.parseInt(ss2[0]);
		int fenzi;
		if (preflag.equals("-")){
			fenzi=c1*(fenmu/a1)-c2*(fenmu/a2);
		}else{
			fenzi=c1*(fenmu/a1)+c2*(fenmu/a2);
		}
//		System.out.println(fenzi);
		int gcd2=gcd(fenzi, fenmu);
		
		return String.valueOf(fenzi/Math.abs(gcd2)+"/"+fenmu/Math.abs(gcd2));
	}
	public String fractionAddition(String expression) {
		if (expression==null || expression.length()==0) return "0";
        char pre=Character.isDigit(expression.charAt(0)) ? '+':'-';
//        System.out.println(pre);
        String preNum="0/1";
        String nowNum="";
        int i= (pre=='+' ? 0:1);
        for (;i<expression.length();){
        	int j=i;
        	while (j<expression.length() && (expression.charAt(j)!='+' && expression.charAt(j)!='-')){
        			j++;
        		}
        	nowNum=expression.substring(i, j);
        	i=j+1;
        	String ans=compute(preNum, nowNum, ""+pre);
        	if (j<expression.length())
        		pre=expression.charAt(j);	
        	preNum=ans;
        	nowNum="";
        	
        }
        
        return preNum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionAdditionandSubtraction592 t=new FractionAdditionandSubtraction592();
		System.out.println(t.fractionAddition("-1/2+1/2"));
	}

}
