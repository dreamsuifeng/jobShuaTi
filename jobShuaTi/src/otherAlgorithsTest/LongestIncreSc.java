package otherAlgorithsTest;

public class LongestIncreSc {
	private static int[] count;

    public int longestIncreaseSubsequence(char[] seq) {
        int n = seq.length;

        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (seq[j] < seq[i]) {
                	max = Math.max(max, count[j]);
                }
            }
            count[i] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
        	System.out.print(count[i]+",");
            if (count[i] > max) max = count[i];
        }
        System.out.println();

        return max;
    }

    public void printLIS(int[] a, int k, int[] count, char[] arr, int max) {
        if (k == max) {
            for (int i = max; i >= 1; i--) {
                System.out.printf("%c ", arr[a[i]]);
            }
            System.out.println();
        } else {
            k++;

            int[] candidates = new int[arr.length];
            int ncandidate = 0;

            for (int i = a[k-1]; i >= 0; i--) {
                if (count[i] == max-k+1 && (arr[i] < arr[a[k-1]] || count[i] == max)) {
                    candidates[ncandidate] = i;
                    ncandidate++;
                }
            }

            for (int i = 0; i < ncandidate; i++) {
                a[k] = candidates[i];
                printLIS(a, k, count, arr, max);
            }
        }
    }

    public static void main(String[] args) {
        char[] input = {'q','a','p','b','s','o','a'};
        LongestIncreSc lis = new LongestIncreSc();

        count = new int[input.length];  

        int max = lis.longestIncreaseSubsequence(input);
        int[] a = new int[max+1];
        a[0] = input.length-1; 

        lis.printLIS(a, 0, count, input, max);
    }
	

}
