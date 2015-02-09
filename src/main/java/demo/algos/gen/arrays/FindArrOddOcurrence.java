package demo.algos.gen.arrays;

/**
 * @author mahobalan
 * 
 *         Given an array of positive integers. All numbers occur even number of
 *         times except one number. Find it.
 *
 */
public class FindArrOddOcurrence {

	public static void main(String[] args) {
		
		FindArrOddOcurrence finder=new FindArrOddOcurrence();
		finder.findOddOccuringNumber(new Integer[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2});
	}
	
	
	/**
	 * @param input
	 * 
	 * Even Occurrences of numbers zero out on XORing.
	 */
	private void findOddOccuringNumber(Integer[] input){
		
		int xorResult=0;
		
		for(Integer i: input){
			xorResult ^=i;
		}
		
		System.out.println("The Odd Occuring Number is :"+ xorResult);
	}
}

