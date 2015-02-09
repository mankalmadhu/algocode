package demo.algos.gen.arrays;

/**
 * given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * 
 * @author mahobalan
 *
 */
public class FindMissingNumber {

	public static void main(String[] args) {

		FindMissingNumber missingnum = new FindMissingNumber();
		missingnum.findMissingNumber(new Integer[] { 1, 2, 4, 6, 3, 7, 8 });
		missingnum.findMissingNumber1(new Integer[] { 1, 2, 4, 6, 3, 7, 8 });
	}

	private void findMissingNumber(Integer[] input) {

		int sumN = ((input.length + 1) * (input.length + 2)) / 2;

		for (Integer i : input) {
			sumN -= i;
		}

		System.out.println("Missing Number is:" + sumN);
	}

	/**
	 * XORing sets the same number results in '0'. So the remaining is the
	 * missing number.
	 * 
	 * @param input
	 */
	private void findMissingNumber1(Integer[] input) {

		int xor1 = 0;

		for (int i = 0; i <= input.length + 1; i++) {
			xor1 ^= i;
		}

		int xor2 = 0;

		for (Integer i : input) {
			xor2 ^= i;
		}

		System.out.println("Missing Number is:" + (xor1 ^ xor2));
	}

}
