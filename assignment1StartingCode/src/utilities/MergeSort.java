package utilities;

import java.util.Comparator;

/**
 * Stable, top-down Merge Sort.
 * - Generic (works with any reference type)
 * - No printing or timing (benchmark outside in AppDriver)
 * - For DESCENDING order, pass a reversed comparator.
 *
 * Examples:
 *   MergeSort.sort(arr, new BaseAreaComparator().reversed());  // by base area, DESC
 *   MergeSort.sort(arr, new VolumeComparator().reversed());    // by volume, DESC
 *   MergeSort.sort(arr);                                       // natural order ASC if T is Comparable
 */
public final class MergeSort {
    private MergeSort() {}

    /** Natural order (ascending) when T implements Comparable. */
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        sort(a, Comparator.naturalOrder());
    }

    /** Sort using the provided comparator (ascending). */
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
        merge(a, aux, lo, mid, hi, cmp);
    }

    /** Merge is STABLE. */
    private static <T> void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<? super T> cmp) {
        for (int i = lo; i < hi; i++) aux[i] = a[i];
        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) {
            if (cmp.compare(aux[i], aux[j]) <= 0) a[k++] = aux[i++];
            else                                   a[k++] = aux[j++];
        }
        while (i < mid) a[k++] = aux[i++];
        while (j < hi)  a[k++] = aux[j++];
    }
}
