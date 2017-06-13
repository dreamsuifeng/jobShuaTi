package otherAlgorithsTest;

import java.util.Scanner;

public class worksappli1 {
	public static void add(int x) {
	    
	  }
	  public static int query(int x) {
	      return 0;
	  }
	  
	  public static void main(String[] args){
	 
	    Scanner in = new Scanner(System.in);
	    int m = in.nextInt();
	    int mod = in.nextInt();
	    while(m-- > 0){
	      String ch = in.next();
	      int x = in.nextInt();
	  
	      if(ch.equals("I")){
	        add(x);
	      } else {
	        System.out.println(query(x));
	      }
	    }
	  }

}
