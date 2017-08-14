package LeetCode;

public class SingleElementinaSortedArray540 {
	private int sigle(int[] nums, int l,int r){
		int mid=l-(l-r)/2;
		int left=mid;
		int right=nums.length-mid-1;
		if (l==r) return nums[l];
		if (mid-1>=l && nums[mid]==nums[mid-1]) {
			left++;
			return left%2==0 ? sigle(nums, mid+1, r):sigle(nums, l, mid-2);
		}
		else if (mid+1<=r && nums[mid]==nums[mid+1]) {
			right++;
			return left%2==0 ? sigle(nums, mid+2, r):sigle(nums, l, mid-1);
		}
		else return nums[mid];
	}
	public int singleNonDuplicate(int[] nums) {
        return sigle(nums, 0, nums.length-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleElementinaSortedArray540 t=new SingleElementinaSortedArray540();
		int[] nums={1,1,2,2,4,4,5,5,9};
		System.out.println(t.singleNonDuplicate(nums));
	}

}
