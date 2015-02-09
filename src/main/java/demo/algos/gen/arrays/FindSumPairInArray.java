package demo.algos.gen.arrays;

import demo.algos.sorting.quick.QuickSort;

/**
 * @author mahobalan
 * 
 *         given an array A[] of n numbers and another number x, determines
 *         whether or not there exist two elements in S whose sum is exactly x
 *
 */
public class FindSumPairInArray {

	public static void main(String[] args) {

		FindSumPairInArray findSum = new FindSumPairInArray();
		findSum.findSumPair(new Integer[] { 1, 4, 45, 6, 10, -8 }, 16);
	}

	private void findSumPair(Integer[] input, int sum) {

		QuickSort<Integer> sort = new QuickSort<Integer>(input);
		sort.sort();

		int low = 0;
		int high = input.length - 1;

		while (low < high) {

			if (input[low] < sum - input[high]) {

				low++;

			} else if (input[low] > sum - input[high]) {
				high--;
			} else {
				System.out.println("Sum for:" + sum + " is in:" + low + "-"
						+ input[low] + " and :" + high + "-" + input[high]);
				break;
			}

		}

	}
}
