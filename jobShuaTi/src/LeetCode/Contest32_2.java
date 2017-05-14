package LeetCode;

public class Contest32_2 {
	private int resint=-1;
	public static int[] maxUtil2(String str1, String str2) {
        
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        int[][] temp = new int[arr1.length][arr2.length];
        
        int length = 0;
        
        int end2 = 0;
        int start2 = 0;
        int end1 = 0;
        int start1 = 0;
        for (int i = 0; i < arr2.length; i++) {
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
            if (temp[0][i] > length) {
                length = temp[0][i];
//                end2 = i;
                end1=i;
            }
        }
       
        for (int j = 0; j < arr1.length; j++) {
            temp[j][0] = (arr2[0] == arr1[j]) ? 1 : 0;
            if (temp[j][0] > length) {
                length = temp[j][0];
                end2 = j;
//                end1=j;
            }
        }
        
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;

                    if (temp[i][j] > length) {
                        length = temp[i][j];
                        end2 = j;
                        end1=i;
                    }
                } else
                    temp[i][j] = 0;

            }
        }
        
        start2=end2-length+1;
        start1=end1-length+1;
        StringBuilder sb=new StringBuilder();
        int[] res=new int[4];
        res[0]=start1;
        res[1]=end1;
        res[2]=start2;
        res[3]=end2;
        for (int j = start2; j < end2+1; j++) {
            sb.append(arr2[j]);
        }
        System.out.println(sb.toString());
        return res;
    }
	public void findDistance(String word1, String word2){
		if (word1.equals(word2)) {
			resint-=word1.length()*2;
			return;
		}
		if (word1.length()==0 ||word2.length()==0) return;
		int[] temp=maxUtil2(word1, word2);
		int len=temp[1]-temp[0]+1;
		if (len==0){
			return;
		}else{
			resint-=2*(temp[1]-temp[0]+1);
//			System.out.println(resint);
			findDistance(word1.substring(0, temp[0]), word2.substring(0, temp[2]));
			findDistance(word1.substring(temp[1]+1, word1.length()), word2.substring(temp[3]+1, word2.length()));
		}
		
	}
	public int minDistance(String word1, String word2) {
        resint=word1.length()+word2.length();
        findDistance(word1, word2);
        return resint;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contest32_2 t=new Contest32_2();
		System.out.println(t.minDistance("gorithm"
				,"truistic"));
	}

}
