package hihoCoder;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class LeetCode1539 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		in.nextLine();
		
		for (int i=0;i<T;++i){
			String line=in.nextLine();
			String target="";
			for (int j=0;j<line.length();++j){
				target+=(j+1);
			}
			if (target.equals(line)){
				System.out.println(0);
			}else{
				int count=0;
				boolean flag=false;
				Set<String> used=new HashSet<>();
				List<String> now=new LinkedList<>();
				used.add(line);
				now.add(line);
				while (now.size()>0){
					count++;
					List<String> tmp=new LinkedList<String>();
					for (String s:now){
						for (int r=0;r<s.length()-1;r++){
							String insert=s.substring(r, r+2);
							String beiInsert=s.substring(0,r)+s.substring(r+2);
							for (int c=0;c<beiInsert.length();++c){
								String newString=beiInsert.substring(0, c)+insert+beiInsert.substring(c);
								if (newString.equals(target)){
									flag=true;
									break;
								}
								if (!used.contains(newString)){
									used.add(newString);
									tmp.add(newString);
								}
							}
							if (flag){
								break;
							}
						}
						if (flag){
							break;
						}
					}
					if (flag){
						break;
					}
					now=tmp;
				}
				System.out.println(flag ? count:-1);
			}
		}
	}

}
