package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class Contest38_4 {
	int[][] data;
	HashMap<String, LinkedList<String>> map;
	public Contest38_4(int H, char W) {
		map=new HashMap<>();
        data=new int[H][W-'A'+1];
    }
    
    public void set(int r, char c, int v) {
    	int diff=v-data[r-1][c-'A'];
        data[r-1][c-'A']=v;
        String st=String.valueOf(c)+String.valueOf(r);
        if (map.containsKey(st)){
        	LinkedList<String> tl=map.get(st);
        	for (int i=0;i<tl.size();++i){
        		String tsString=tl.get(i);
        		int row=Integer.valueOf(tsString.substring(1));
        		char col=tsString.charAt(0);
        		int val=get(row, col);
        		set(row, col, val+diff);
        	}
        }
    }
    
    public int get(int r, char c) {
        return data[r-1][c-'A'];
    }
    
    public int sum(int r, char c, String[] strs) {
        int res=0;
        for (String s:strs){
        	int tmp=0;
        	String[] liStrings=s.split(":");
        	if (liStrings.length==1){
        		tmp+=get(Integer.valueOf(liStrings[0].substring(1)),liStrings[0].charAt(0));
        		if (map.containsKey(liStrings[0])){
        			map.get(liStrings[0]).add(String.valueOf(c)+String.valueOf(r));
        		}else{
        			LinkedList<String> tlLinkedList=new LinkedList<>();
        			tlLinkedList.add(String.valueOf(c)+String.valueOf(r));
        			map.put(liStrings[0], tlLinkedList);
        		}
        	}else{
        		int lowh=Integer.valueOf(liStrings[0].substring(1));
        		char loww=liStrings[0].charAt(0);
        		int highH=Integer.valueOf(liStrings[1].substring(1));
        		char highW=liStrings[1].charAt(0);
        		for (int i=lowh;i<=highH;++i){
        			for (char j=loww;j<=highW;++j){
        				tmp+=get(i, j);
        				String st=String.valueOf(j)+String.valueOf(i);
        				if (map.containsKey(st)){
        					map.get(st).add(String.valueOf(c)+String.valueOf(r));
        				}else{
        					LinkedList<String> tlLinkedList=new LinkedList<>();
                			tlLinkedList.add(String.valueOf(c)+String.valueOf(r));
                			map.put(st, tlLinkedList);
        				}
        			}
        		}
        	}
        	set(r, c, res);
        	res+=tmp;
//        	System.out.println(map.toString());
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contest38_4 t=new Contest38_4(3, 'C');
		String[] t1={"A2"};
		System.out.println(t.sum(1, 'A', new String[]{"A2"}));
		t.set(2, 'A', 1);
		System.out.println(t.get(1, 'A'));
	}

}
