package LeetCode;

public class CountPrimes {
	private int count=0;
	public int[] getPrimeNums(int maxNum){
		int[] primeNums = new int[maxNum/2+1];
		int sqrtRoot;
		int cursor = 0;
		boolean isPrime;
		for(int i=2;i<=maxNum;i++){
			sqrtRoot = (int)Math.sqrt(i); //取平方根
			isPrime = true;
			for(int j=0;j< cursor;j++){
				if(primeNums[j]>sqrtRoot)
					break;
				if(i%primeNums[j]==0){
					isPrime = false;
					break;
					}
				}
			if(isPrime){

			primeNums[cursor++] = i;
			}

		}
		count=cursor;
		int[] result = new int[cursor];
		System.arraycopy(primeNums,0,result,0,cursor);
		return result;
		}
	public int countPrimes(int n) {
        getPrimeNums(n);
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] res=getPrimeNums(100);
//		for (int i : res) {
//			System.out.print(i+",");
//		}
		System.out.println(Integer.valueOf('z'));
	}

}
