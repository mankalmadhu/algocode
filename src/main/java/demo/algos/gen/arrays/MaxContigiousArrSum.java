package demo.algos.gen.arrays;

public class MaxContigiousArrSum {

	public static void main(String[] args) {

		MaxContigiousArrSum sumCalc = new MaxContigiousArrSum();
		sumCalc.maxContSum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 });
		sumCalc.maxContSum(new int[] { -2, -3, -4, -1, -2, -1, -5, -3 });
		sumCalc.maxContSum1(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 });
		sumCalc.maxContSum1(new int[] { -2, -3, -4, -1, -2, -1, -5, -3 });

	}

	// Does not work for all -ve numbers-returns 0.
	void maxContSum(int[] input) {
		int maxSum = 0, curSum = 0;

		for (int i = 0; i < input.length; i++) {
			curSum += input[i];

			if (curSum < 0) {
				curSum = 0;
			}

			if (maxSum < curSum) {
				maxSum = curSum;
			}
		}

		System.out.println(maxSum);
	}

	void maxContSum1(int[] input) {
		// Crucial to have both to input[0] rather than '0'. Otherwise for all
		// -ves 0 would be max.
		int maxSum = input[0], curSum = input[0];

		for (int i = 0; i < input.length; i++) {
			// Works with all -ve numbers because if cursum+input[i] is less
			// then input[i] least of the -ve numbers is in curSum
			curSum = Math.max(input[i], curSum + input[i]);
			maxSum = Math.max(curSum, maxSum);
		}

		System.out.println(maxSum);
	}

}
