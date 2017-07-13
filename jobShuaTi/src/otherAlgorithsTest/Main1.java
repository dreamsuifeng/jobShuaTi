package otherAlgorithsTest;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(",");
        if (s.length()==0) return;
        LinkedList<int[]> q=new LinkedList<>();
        for(int i=0; i<ss.length; i++){
        	int[] tmp=new int[2];
        	tmp[0]=i;
        	tmp[1]=Integer.parseInt(ss[i].trim());
        	q.add(tmp);
        }
        String res = "";
        while(!q.isEmpty()){
        	int[] t=q.pollFirst();
        	boolean flag=true;
        	for (int i=0;i<q.size();++i){
        		if (q.get(i)[1]>t[1]){
        			flag=false;
        			break;
        		}
        	}
        	if (flag){
        		res+=t[0]+", ";
        	}else{
        		q.add(t);
        	}
        }
    	System.out.println(res.substring(0, res.length()-2));
        in.close();
    }
    
}
