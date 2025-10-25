package utilities;

import java.util.Comparator;

/**
 * SelectionSort.java
 *
 * @author Theo Sanchez
 * @version 1.8 
 * 
 * Class Definition: Demonstrates a Merge Sort algorithm using the Comparator interface.
 *                   Works generically over reference types and orders elements strictly
 *                   according to the provided Comparator (or natural order when applicable).
 * 
 */
public final class MergeSort {
    private MergeSort() {}

    /** Natural order (DESC) when T implements Comparable. */
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, Comparator.naturalOrder());
    }

    /** Sort using the provided comparator; result is DESCENDING. */
    public static <T> void sort(T[] a, Comparator<? super T> cmp) {
        if (a == null || a.length < 2) return;
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Object[a.length];
        sort(a, aux, 0, a.length, cmp);
    }

    private static <T> void sort(T[] a, T[] aux, int lo, int hi, Comparator<? super T> cmp) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, cmp);
        sort(a, aux, mid, hi, cmp);
        mergeDescendingStable(a, aux, lo, mid, hi, cmp);
    }

    /** Merge two sorted halves into DESCENDING order, stably. */
    private static <T> void mergeDescendingStable(T[] a, T[] aux, int lo, int mid, int hi,
                                                  Comparator<? super T> cmp) {
        System.arraycopy(a, lo, aux, lo, hi - lo);
        int i = lo, j = mid, k = lo;

        while (i < mid && j < hi) {
            // DESCENDING: place the larger (per cmp) first.
            // Stability: when equal, take from the left half.
            if (cmp.compare(aux[i], aux[j]) >= 0) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }
        while (i < mid) a[k++] = aux[i++];
        while (j < hi)  a[k++] = aux[j++];
    }
}
