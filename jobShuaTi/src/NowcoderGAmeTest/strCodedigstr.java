package NowcoderGAmeTest;

import java.util.Scanner;

public class strCodedigstr {
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        char[] s=in.next().toCharArray();
        int count=0;
        char t=s[0];
        StringBuffer sb=new StringBuffer();
        for (char c:s){
            if (c==t) count++;
            else{
                sb.append(String.valueOf(count)+t);
                count=1;
                t=c;
            }
        }
        if (count>0)
        	sb.append(String.valueOf(count)+t);
        System.out.println(sb.toString());
        
    }
}
