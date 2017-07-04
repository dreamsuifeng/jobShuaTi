package otherAlgorithsTest;

import java.util.Scanner;
import java.util.Set;

import otherAlgorithsTest.Graham;
public class AliTest {
	public static int castle(double[] points){
		
		int n=points.length;
		double[][] newpoints=new double[n/2][2];
		for (int i=0;i<n;){
//			System.out.println(points[i]);
			newpoints[i/2][0]=points[i];
			i++;
			newpoints[i/2][1]=points[i];
//			System.out.println(newpoints[i/2][0]+","+newpoints[i/2][1]);
			i++;
			
		}
		Graham graham=new Graham(newpoints);
		Set<String> tupoints=graham.findtupoints();
//		for(String s :tupoints){
//			
//			System.out.println(s);
//		}
		int res=0;
		for (int i=0;i<n/2;++i){
			String tmp=newpoints[i][0]+","+newpoints[i][1];
			if (tupoints.contains(tmp)){
//				System.out.println("tudian");
				continue;
			}
			for (int j=0;j<n/2;++j){
				if (i==j) continue;
				int suml=0;
				int sumr=0;
				int sum=0;
				if (newpoints[i][0]==newpoints[j][0]){
					for (int k=0;k<n/2;++k){
						if (newpoints[k][0]<newpoints[i][0]){
							suml++;
						}
						if (newpoints[k][0]>newpoints[i][0]){
							sumr++;
						}
						if (newpoints[k][0]==newpoints[i][0]){
							sum++;
						}
					}
					
				}
				else{
					double xielv=(newpoints[i][1]-newpoints[j][1])/(newpoints[i][0]-newpoints[j][0]);
					double C=-(newpoints[i][1]+newpoints[i][0]);
//					System.out.println(xielv+","+C);
					for (int k=0;k<n/2;++k){
						double label=newpoints[k][1]+C-xielv*newpoints[k][0];
						if (label<0){
							suml++;
						}
						if (label>0){
							sumr++;
						}
						if (label==0){
							sum++;
						}
					}
				}
				
					res=Math.max(res, Math.max(suml+ (sum>2 ? sum-1:sum), sumr+(sum>2 ? sum-1:sum)));
				
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int res;
            
        int _points_size = 0;
        _points_size = Integer.parseInt(in.nextLine().trim());
        double[] _points = new double[_points_size];
        double _points_item;
        for(int _points_i = 0; _points_i < _points_size; _points_i++) {
            _points_item = Double.parseDouble(in.nextLine().trim());
            _points[_points_i] = _points_item;
        }
    
        res = castle(_points);
        System.out.println(String.valueOf(res));  
	}

}
