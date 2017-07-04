package otherAlgorithsTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 凸包寻找，Graphm算法
 */
public class Graham {

	static int MAX = 100015;  
    static POINT[] point = new POINT[MAX];  
    static int[] stack = new int[MAX];  
    static int n;  
    static int top;  
  
    static class POINT  
    {  
        public double x,y;  
        public POINT(double x,double y){  
            this.x = x;  
            this.y = y;  
        }  
    }  
    public Graham(double[][] in){
    	n=in.length;
    	for(int i = 0;i < n;i++){  
            double x = in[i][0];  
           double y = in[i][1];  
            point[i] = new POINT(x,y);  
        }  
    }
    //(p1-p0)x(p2-p0),判断两直线的相对位置  
    static double xmul(POINT p1,POINT p2,POINT p0){  
        return (p1.x-p0.x)*(p2.y-p0.y) - (p2.x-p0.x)*(p1.y-p0.y);  
    }  
      
    static double distance(POINT p1,POINT p2){  
        return (p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y);  
    }  
      
     void swap(int i,int j){  
        POINT tmp = point[i];  
        point[i] = point[j];  
        point[j] = tmp;  
    }  
      
     void grahamscan(int n){  
    //  if(n<2)  
        int u = 0,i = 0;  
        for(;i < n;i++)  
            if((point[i].y < point[u].y)||(point[i].y == point[u].y && point[i].x<point[u].x ))  
             u = i;  
        swap(u,0);  
        Arrays.sort(point,0,n,new MyComp());  
        for(i=0;i<3;i++) stack[i] = i; //point0 point1 point2入栈  
        top = 2;  
        for(i = 3;i < n;i++){  
            while(xmul(point[i],point[stack[top]],point[stack[top-1]]) >= 0){//弹出非左转的点  
                if(top == 0) break;  
                top--;  
            }  
            stack[++top] = i;  
        }  
    }  
      
    static class MyComp implements Comparator<POINT>  
    {  
        public int compare(POINT p1,POINT p2){  
            double xm = xmul(p1,p2,point[0]);  
            if(xm < 0) return 1;  
            else if(xm == 0 && distance(p1,point[0])>distance(p2,point[0])) return 1;  
            else return -1;  
        }  
    }  
  
     double area(int n){  
        double area = 0;  
        for(int i = 2;i <= n-1;i++){  
            area += xmul(point[stack[i]],point[stack[i-1]],point[0]);  
        }  
        return Math.abs(area)/2;  
    }  
      
     void input(){  
        int x=0,y=0;  
        Scanner cin = new Scanner(System.in);  
        System.out.println("请输入点数");  
        n = cin.nextInt();  
        System.out.println("请输入x,y");  
        for(int i = 0;i < n;i++){  
            x = cin.nextInt();  
            y = cin.nextInt();  
            point[i] = new POINT(x,y);  
        }  
    }
    public Set<String> findtupoints(){
    	grahamscan(n);
    	Set<String> reSet=new HashSet<>();
    	for(int i=0;i<=top;i++){
    		StringBuilder sb=new StringBuilder();
    		sb.append(point[stack[i]].x);
    		sb.append(",");
    		sb.append(point[stack[i]].y);
            reSet.add(sb.toString());  
        }
    	return reSet;
    }
  
    static void print(){  
        System.out.println("凸包:");  
        for(int i=0;i<=top;i++){  
            System.out.print("("+point[stack[i]].x+","+point[stack[i]].y+")"+"-");  
        }  
        System.out.println("("+point[stack[0]].x+","+point[stack[0]].y+")");  
    }  
    public static void main(String[] args){  
    } 

}
