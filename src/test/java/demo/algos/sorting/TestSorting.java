package demo.algos.sorting;

import java.util.Arrays;

import org.junit.Test;

import demo.algos.sorting.merge.MergeSort;

public class TestSorting {

	private Integer[] input = new Integer[] { 3, 5, 6, 2, 1 };

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

}
