package otherAlgorithsTest;


public class quickSort {
	private int pration(int[] array,int beg, int end){
		int last = array[end];  
        int i = beg -1;  
        for (int j = beg; j <= end-1; j++) {  
            if(array[j] <= last){  
                i++;  
                if(i != j){  
                    array[i] = array[i]^array[j];  
                    array[j] = array[i]^array[j];  
                    array[i] = array[i]^array[j];  
                }  
            }  
        }  
        if((i+1) != end){  
            array[i+1] = array[i+1]^array[end];
            array[end] = array[i+1]^array[end];  
            array[i+1] = array[i+1]^array[end];  
        }  
        return i+1; 
	}
	public void quicksort(int[] nums,int beg,int end){
		if(beg >= end || nums == null)  
            return;  
		int p=pration(nums,beg,end);
		quicksort(nums,0,p-1);
		quicksort(nums,p+1,end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quickSort t=new quickSort();
		int[] a=new int[]{2,1,3,4,2,3};
		t.quicksort(a,0,5);
		for (int i:a){
			System.out.println(i);
		}
		int b=(int)'1'+1;
		System.out.println((char)b);
	}
	
}
