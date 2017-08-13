package NowcoderGAmeTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class hungryXiaoyi {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
            int x=in.nextInt();
            Map<Long, Integer> map=new HashMap<Long, Integer>();
             
            Queue<Long> queue=new LinkedList<Long>();
            queue.offer((long)x);
            map.put((long)x, 1);
 
            while(!queue.isEmpty()){
                long n=queue.poll();
                if(n==0) {System.out.println(map.get(n)-1); return;}
                if(map.get(n)>=100001) continue;
                 
                if(!map.containsKey((4*n+3)%1000000007)){
                    map.put((4*n+3)%1000000007, map.get(n)+1);
                    queue.offer((4*n+3)%1000000007);
                }
                if(!map.containsKey((8*n+7)%1000000007)){
                    map.put((8*n+7)%1000000007, map.get(n)+1);
                    queue.offer((8*n+7)%1000000007);
                }
            }
            System.out.println(-1);
        }
	}
}
