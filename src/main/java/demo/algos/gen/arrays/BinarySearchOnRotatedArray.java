package demo.algos.gen.arrays;

/**
 * @author mahobalan
 * 
 *         rotate the sorted array at some pivot unknown to you beforehand. So
 *         for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find
 *         an element in the rotated array in O(log n) time.
 *
 */
public class BinarySearchOnRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinarySearchOnRotatedArray binSearch = new BinarySearchOnRotatedArray();

		Integer[] input = { 3, 4, 5, 1, 2 };

		Integer search = 2;

		Integer pivot = binSearch.findRotatedPivot(input);

		Integer result = 0;

		if (pivot == -1) {
			result = binSearch.binarySearch(search, 0, input.length - 1, input);
		} else if (input[pivot] == search) {
			result = pivot;
		}/**
		 * Start Comparing with 0 th element since the pivot may not be always
		 * in middle
		 **/
		else if (search < input[0]) {
			result = binSearch.binarySearch(search, pivot + 1,
					input.length - 1, input);

		} else {
			result = binSearch.binarySearch(search, 0, pivot - 1, input);
		}

		System.out.println(pivot);
		System.out.println("Found At:" + result + " :" + input[result]);

		binSearch.pivotedBinarySearch(input, search);
	}

	private Integer findRotatedPivot(Integer[] input) {

		for (int i = 1; i < input.length; i++) {
			if (input[i - 1] > input[i]) {
				return (i - 1);
			}
		}

		return -1;
	}

	private Integer binarySearch(int search, int low, int high, Integer[] input) {

		int result = -1;

		if (low > high) {
			result = -1;
			return result;
		}

		int mid = (low + (high - low) / 2);

		if (search < input[mid]) {
			result = binarySearch(search, low, mid - 1, input);
		} else if (search > input[mid]) {
			result = binarySearch(search, mid + 1, high, input);
		} else {
			result = mid;
		}

		return result;

	}

	/**
	 * @param input
	 * @param search
	 * 
	 *            In each sub array see if the element is in between the range.
	 *            Else check in other sub array. This counters for the
	 *            distortion caused by pivot rotating sorted array.
	 * 
	 */
	private void pivotedBinarySearch(Integer[] input, int search) {

		int low = 0;
		int high = input.length - 1;

		while (low <= high) {

			int mid = (low + (high - low) / 2);

			if (search == input[mid]) {
				System.out.println("Element :" + search + " Found at:" + mid);
				break;
			} else if (search < input[mid]) {

				if (search >= input[low] && search < input[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else {

				if (search > input[mid] && search <= input[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}

			}

		}

	}
}
