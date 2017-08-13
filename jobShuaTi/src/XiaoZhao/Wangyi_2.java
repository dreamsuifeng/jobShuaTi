package XiaoZhao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Wangyi_2 {
	static class qizi{
		long x;
		long y;
		int count;
		public qizi(long x,long y){
			this.x=x;
			this.y=y;
			count=0;
		}
		public String toString(){
			return x+"#"+y;
		}
	}
	public static void main1(String[] args){
		Scanner scan = new Scanner(System.in);
		        int n = scan.nextInt();
		        int[]X = new int[n];
		        int[]Y = new int[n];
		        for(int i=0;i<n;i++){
		            X[i] = scan.nextInt();
		        }
		        for(int i=0;i<n;i++){
		            Y[i] = scan.nextInt();
		        }
		        int[] res = new int[n];
		        for(int i=0;i<n;i++){
		            res[i] = Integer.MAX_VALUE;
		        }
		        for(int i=0;i<n;i++){
		            for(int j=0;j<n;j++){
		                for(int k=0;k<n;k++){
		                    int[] res2 = new int[n];
		                    for(int l=0;l<n;l++){
		                        res2[l] = Math.abs(X[l]-X[j])+Math.abs(Y[l]-Y[k]);
		                    }
		                    Arrays.sort(res2);
		                    int res3 = 0;
		                    for(int l=0;l<=i;l++){
		                        res3 = res3 + res2[l];
		                    }
		                    res[i] = Math.min(res3, res[i]);
		                }
		            }
		        }
		        for(int i=0;i<n;i++){
		            if(i<n-1){
		                System.out.print(res[i]+" ");
		            }else{
		                System.out.print(res[i]);
		            }
		        }
		    }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long[][] xy=new long[n][2];
		ArrayList<qizi> list=new ArrayList<>();
		HashMap<String, Integer> map=new HashMap<>();
		for (int i=0;i<n;i++){
			xy[i][0]=in.nextLong();
			
		}
		for (int i=0;i<n;i++){
			xy[i][1]=in.nextLong();
			
		}
		
		for (int i=0;i<n;i++){
			String string=xy[i][0]+"#"+xy[i][1];
			if (map.containsKey(string)){
				map.put(string, map.get(string)+1);
			}else{
				map.put(string, 1);
			}
			
		}
		
		Iterator<Map.Entry<String, Integer>> it=map.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<String, Integer> tmp=it.next();
			String[] sc=tmp.getKey().split("#");
			qizi t=new qizi(Long.parseLong(sc[0]), Long.parseLong(sc[1]));
			t.count=tmp.getValue();
			list.add(t);
		}
		Collections.sort(list,new Comparator<qizi>() {

			@Override
			public int compare(qizi o1, qizi o2) {
				// TODO Auto-generated method stub
				return o1.count-o2.count;
			}
		});
		int[] ans=new int[n];
		int len=list.size();
		for (int i=1;i<=n;++i){
			long maxstep=Integer.MAX_VALUE;
			for (int k=0;k<len;++k){
				long sum=0;
				int j=k;
				for (j=k;j<len;++j){
					sum+=list.get(j).count;
					if (sum>=i){
						break;
					}
				}
				if (j>=len) continue;
				long x0=list.get(j).x;
				long y0=list.get(j).y;
				long step=0;
				for (int jj=k;jj<j;++jj){
					long x=Math.abs(list.get(jj).x-x0);
					long y=Math.abs(list.get(jj).y-y0);
					step+=(x+y)*list.get(jj).count;
				}
				
				if (step<maxstep){
					maxstep=step;
				}
				
		
		}
			
			ans[i-1]=(int) maxstep;
		}
		
		for (int i=0;i<n;++i){
			System.out.print(ans[i]);
			if (i<n-1){
				System.out.print(" ");
			}
		}
		
		
	}

}
