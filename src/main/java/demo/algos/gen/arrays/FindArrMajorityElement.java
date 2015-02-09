package demo.algos.gen.arrays;

/**
 * @author mahobalan
 * 
 *         A majority element in an array A[] of size n is an element that
 *         appears more than n/2 times
 *
 */
public class FindArrMajorityElement {

	public static void main(String[] args) {

		FindArrMajorityElement finder = new FindArrMajorityElement();
		finder.findMajElem(new Integer[] { 2, 2, 3, 5, 2, 2, 6 });

	}

	/**
	 * @param input
	 * 
	 * Using Moore’s Voting Algorithm
	 */
	private void findMajElem(Integer[] input) {

		int majorElemCount = 0;

		int majorElemIndex = 0;

		for (int i = 0; i < input.length; i++) {

			if (input[majorElemIndex] == input[i]) {
				majorElemCount++;
			} else {
				majorElemCount--;
			}

			if (majorElemCount == 0) {
				majorElemIndex = i;
				majorElemCount = 1;
			}
		}

		majorElemCount = 0;
		for (Integer i : input) {
			if (i == input[majorElemIndex]) {
				majorElemCount++;
			}

			if (majorElemCount > input.length / 2) {
				System.out.println("Majority Element Found at:"
						+ majorElemIndex + " and value:" + i);
				return;
			}
		}
	}

}
