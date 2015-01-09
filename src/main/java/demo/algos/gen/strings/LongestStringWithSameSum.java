package demo.algos.gen.strings;

/**
 * @author mahobalan
 * 
 *         Examples:
 * 
 *         Input: str = "123123" Output: 6 The complete string is of even length
 *         and sum of first and second half digits is same
 * 
 *         Input: str = "1538023" Output: 4 The longest substring with same
 *         first and second half sum is "5380"
 * 
 *
 */
public class LongestStringWithSameSum {

	public static void main(String[] args) {
		LongestStringWithSameSum sums = new LongestStringWithSameSum();
		sums.symmetricLongSum("153803");
		sums.symmetricLongSum("123123");
	}

	void symmetricLongSum(String input) {

		int[][] sum = new int[input.length()][input.length()];

		int i = 0;

		for (i = 0; i < input.length(); i++) {
			sum[i][i] = Integer.parseInt(input.substring(i, i + 1));
		}

		int maxLen = 0;

		// 1) Zeroth Iteration (length=2), sum [i][i](diagonal elems) and place
		// result in [i][i+1] E.g: sum[0][1]=sum[0][0]+sum[1][1].

		// 2) Odd Iteration(length is odd) : E.g :
		// sum[0][2]=sum[0][1]+[2][2](Note : sum[1][*] is skipped because
		// sum[0][1] already contains this sum).

		// 3) Even Iteration (length is even : E.g:
		// sum[0][3]=sum[0][1]+sum[2][3](Note: both [0][1] and [2][3] are
		// computed in previous even iteration. In this case '0'th iteration).
		for (int len = 2; len <= sum.length; len++) {
			for (i = 0; i < input.length() - len + 1; i++) {

				int j = i + len - 1;
				int k = len / 2;

				sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];

				if (len % 2 == 0 && (sum[i][j - k] == sum[j - k + 1][j])
						&& len > maxLen) {
					maxLen = len;
				}

			}
		}

		System.out.println(maxLen);
	}

}
