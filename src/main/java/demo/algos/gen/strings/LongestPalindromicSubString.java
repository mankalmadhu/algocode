package demo.algos.gen.strings;

public class LongestPalindromicSubString {

	public static void main(String[] args) {

		LongestPalindromicSubString pal = new LongestPalindromicSubString();
		pal.maxPalLen("lakshmimadam");
		pal.maxPalLen("lakshmimaddam");
		pal.maxPalLenWithPreProcess("lakshmimadam");
		pal.maxPalLenWithPreProcess("lakshmimaddam");

	}

	private void maxPalLen(String input) {

		Tuple<Integer, Integer> cur = new Tuple<Integer, Integer>(0, 0);

		for (int i = 1; i < input.length(); i++) {

			// Check for Odd Length Palindrome in current range
			calculatePalLen(input, i + 1, i - 1, cur);
			// Check for EVen length Palindrome in current range
			calculatePalLen(input, i, i - 1, cur);

		}

		System.out.println(cur.maxlen);
		System.out.println(input.substring(cur.start, cur.start + cur.maxlen));

	}

	private void maxPalLenWithPreProcess(String input) {

		Tuple<Integer, Integer> cur = new Tuple<Integer, Integer>(0, 0);

		input = preProcess(input);

		for (int i = 1; i < input.length(); i++) {
			// Since a identical character is inserted in entire string(in even
			// positions), the palindrome would always be of odd length
			calculatePalLen(input, i + 1, i - 1, cur);

		}

		String result = input.substring(cur.start, cur.start + cur.maxlen)
				.replaceAll("#", "");
		System.out.println(result.length());
		System.out.println(result);

	}

	private String preProcess(String input) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			sb.append("#");
			sb.append(input.substring(i, i + 1));
		}
		sb.append("#");

		return sb.toString();

	}

	private void calculatePalLen(String input, int high, int low,
			Tuple<Integer, Integer> cur) {

		char[] charArr = input.toCharArray();

		while (low >= 0 && high < input.length()
				&& (charArr[high] == (charArr[low]))) {
			if ((high - low + 1) > cur.maxlen) {
				cur.maxlen = high - low + 1;
				cur.start = low;
			}

			low--;
			high++;

		}

	}

	private class Tuple<V, U> {

		V maxlen;
		U start;

		public Tuple(V maxlen, U start) {
			super();
			this.maxlen = maxlen;
			this.start = start;
		}

	}

}
