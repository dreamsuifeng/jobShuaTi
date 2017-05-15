package LeetCode;

public class CompareVersionNumbers {
	 public static int compareVersion(String version1, String version2) {
	        int len1=version1.length();
	        int len2=version2.length();
	        int i=0,j=0;
	        int start1=i,start2=j;
	        while(i<len1 && j<len2){
	            while(i<len1 && version1.charAt(i)!='.') i++;
	            while(j<len2 && version2.charAt(j)!='.') j++;
	            
	            int t1=Integer.parseInt(version1.substring(start1,i));
	            int t2=Integer.parseInt(version2.substring(start2,j));
	            
	            if (t1>t2) return 1;
	            else if (t1<t2) return -1;
	            else {
	            	
	            	i++;
	            	j++;
	            	start1=i;
	            	start2=j;
	            }
	            
	        }
	        if (i==len1+1 && j==len2+1){
	        	return 0;
	        }
	        if (i<len1+1) {
	        	int t=Integer.parseInt(version1.substring(start1).replace(".",""));
	        	if (t>0) return 1;
	        	else return 0;
	        }
	        else {
	        	int t=Integer.parseInt(version2.substring(start2).replace(".",""));
	        	if (t>0) return -1;
	        	else return 0;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("ab.".charAt(0)!='.');
		System.out.println(compareVersion("13.0", "13"));
//		System.out.println("00001.11".replace(".",""));
	}

}
