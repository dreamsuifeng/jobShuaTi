package LeetCode;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
	    int bottom = Math.max(B,F), top = Math.max(Math.min(D,H), bottom);
	    return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
