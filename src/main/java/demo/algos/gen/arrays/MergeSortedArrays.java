package demo.algos.gen.arrays;

import demo.algos.sorting.SortUtil;

import java.util.Arrays;

/**
 * Created by madhu on 28/2/15.
 */
public class MergeSortedArrays {

    public static void main(String[] p) {

        Integer[] mn = new Integer[]{null, 2, 3, 4, null, 6, null};

        Integer[] n = new Integer[]{1, 5, 7};

        MergeSortedArrays sortedArrays = new MergeSortedArrays();
        sortedArrays.moveMElemsToEnd(mn);
        sortedArrays.mergeArrays(mn, n);

        System.out.println(Arrays.toString(mn));
    }


    private void moveMElemsToEnd(Integer[] input) {

        int endIndex = input.length - 1;

        for (int i = input.length - 1; i >= 0; i--) {

            if (input[i] != null) {
                SortUtil.exch(input, i, endIndex--);
            }

        }

    }

    private void mergeArrays(Integer[] mn, Integer[] n) {

        int mStart = n.length;

        int nStart = 0;

        for (int i = 0; i < mn.length; i++) {
            if ((nStart < n.length)) {

                if ((mStart < mn.length) && (SortUtil.less(mn[mStart], n[nStart]))) {
                    mn[i] = mn[mStart++];
                } else {
                    mn[i] = n[nStart++];

                }
            }


        }

    }
}
