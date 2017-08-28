package templates;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ToutiaoPinTu {
	static long findMax(HashMap<Long, Integer> maps){
		long max=0;
		Iterator<Long> it=maps.keySet().iterator();
		while (it.hasNext()){
			max=Math.max(max, it.next());
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int nCont=0;
		long max=0;
		long sum=0;
		in.nextLine();
		HashMap<Long, Integer> maps=new HashMap<>();
		for (int i=0;i<n;++i){
			String[] line=in.nextLine().split(" ");
			if (line[0].equals("1")){
				long len=Long.parseLong(line[1]);
				max=Math.max(max, len);
				nCont++;
				sum+=len;
				if (maps.containsKey(len)){
					maps.put(len,maps.get(len)+1);
				}else{
					maps.put(len, 1);
				}
			}else{
				long len=Long.parseLong(line[1]);
				if (maps.get(len)==1){
					maps.remove(len);
					if (len==max){
						max=findMax(maps);
					}
				}else{
					maps.put(len, maps.get(len)-1);
				}
				nCont--;
				sum-=len;
			}
			
			if (nCont<3){
				System.out.println("No");
			}else if (sum-max>max){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
