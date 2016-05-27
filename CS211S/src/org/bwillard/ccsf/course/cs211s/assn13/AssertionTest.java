
public class AssertionTest {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(getNumber(nums, 5));
	}
	
	public static int getNumber(int[] nums, int pos) {
		if(validIndex(nums, pos)) {
			assert pos > 0;
			assert pos < nums.length;
			return nums[pos];
		}
		throw new AssertionError();
	}

	private static boolean validIndex(int[] numbers, int pos) {
		return pos >0 && pos <= numbers.length;
	}
}
