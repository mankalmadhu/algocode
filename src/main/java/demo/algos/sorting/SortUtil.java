package demo.algos.sorting;

import java.util.Comparator;

public class SortUtil {

	// is v < w ?
	public static <T extends Comparable> boolean less(T v, T w) {
		return (v.compareTo(w) < 0);
	}

	// is v < w ?
	public static <T extends Comparator> boolean less(T c, Object v, Object w) {
		return (c.compare(v, w) < 0);
	}

	// is v < w ?
	public static <T extends Comparable> boolean less(T[] a, int i, int j) {
		return (a[i].compareTo(a[j]) < 0);
	}

	// exchange a[i] and a[j]
	public static <T> void exch(T[] a, int i, int j) {
		T swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
