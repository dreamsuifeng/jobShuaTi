package LeetCode;

public class CountTheRepetitions466 {
	public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String t1=s1;
        String t2=s2;
        for (int i=0;i<t2.length();++i){
        	if (t1.indexOf(t2.charAt(i))==-1) return 0;
        }
        int i=0,j=0;
        int m=0,n=0;
        while (m<n1*s1.length()){
        	if (t1.charAt(i)==t2.charAt(j)){
        		i=(i+1)%t1.length();
        		j=(j+1)%t2.length();
        		m++;
        		n++;
        	}else{
        		i=(i+1)%t1.length();
        		m++;
        	}
        	if (i==0 && j==0) break;
        }
        System.out.println(m+","+n);
//        System.out.println(t1.length()+","+t2.length());
       return (n1/(m%t1.length()==0 ?m/t1.length():m/t1.length()+1))*(n/t2.length())/n2; 	
        }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxRepetitions("niconiconi", 99981, "nico", 81));
	}

}
