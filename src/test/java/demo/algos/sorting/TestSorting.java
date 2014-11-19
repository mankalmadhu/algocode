package demo.algos.sorting;

import java.util.Arrays;

import org.junit.Test;

import demo.algos.sorting.merge.MergeSort;
import demo.algos.sorting.merge.MergeSortIterative;
import demo.algos.sorting.quick.QuickSort;
import demo.algos.sorting.quick.QuickSort3WayPartition;
import demo.algos.sorting.quick.QuickSortAlternative;
import demo.algos.sorting.quick.QuickSortIterative;

public class TestSorting {

	private Integer[] input = new Integer[] { 5, 3, 6, 2, 1 };

	@Test
	public void bubbleSort() {
		BubbleSort<Integer> sort = new BubbleSort<Integer>(input);
		sort.sort();
		System.out.println(Arrays.toString(input));
	}

	@Test
	public void selectionSort() {
		SelectionSort<Integer> sort = new SelectionSort<Integer>(input);
		sort.sort();
		System.out.println(Arrays.toString(input));
	}

	@Test
	public void insertionSort() {
		InsertionSort<Integer> sort = new InsertionSort<Integer>(input);
		sort.sort();
		System.out.println(Arrays.toString(input));
	}

	@Test
	public void shellSort() {
		ShellSort<Integer> sort = new ShellSort<Integer>(input);
		sort.sort();
		System.out.println(Arrays.toString(input));
	}

	@Test
	public void mergeSort() {

		MergeSort<Integer> sort = new MergeSort<Integer>(input);
		sort.sort();
		sort.printResult();

	}
	
	@Test
	public void mergeSortIt() {

		MergeSortIterative<Integer> sort = new MergeSortIterative<Integer>(input);
		sort.sort();
		sort.printResult();

	}
	
	@Test
	public void quickSort() {

		QuickSort<Integer> sort = new QuickSort<Integer>(input);
		sort.sort();
		sort.printResult();

	}
	
	@Test
	public void quickSortAlternative() {

		QuickSortAlternative<Integer> sort = new QuickSortAlternative<Integer>(input);
		sort.sort();
		sort.printResult();

	}

	@Test
	public void quickSortIterative() {

		QuickSortIterative<Integer> sort = new QuickSortIterative<Integer>(input);
		sort.sort();
		sort.printResult();

	}


	@Test
	public void quickSort3Way() {

		QuickSort3WayPartition<Integer> sort = new QuickSort3WayPartition<Integer>(input);
		sort.sort();
		sort.printResult();

	}

}
