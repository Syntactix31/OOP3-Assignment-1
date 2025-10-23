    package utilities;

    import java.util.Comparator;

    /**
     * ShellSort class for sorting arrays using the Shell Sort algorithm.
     */
    public class ShellSort {

        public ShellSort() {
            // Default constructor
        }

        /**
         * Sorts an array using the Shell Sort algorithm with a comparator.
         *
         * @param <T>        The type of elements in the array
         * @param array      The array to sort
         * @param comparator The comparator defining the sorting order
         */
        public static <T> void sort(T[] array, Comparator<? super T> comparator) {
            int n = array.length;
            // gap sorting part 1 start with a large gap then make it smaller
            for (int gap = n / 2; gap > 0; gap /= 2) {
            	// gap sorting part 2 do a gapped insertion sort
            	for (int i = gap; i < n; i++) {
                    T temp = array[i];
                    int j;

                    // Descending order if comparator.compare(a, b) < 0
                    for (j = i; j >= gap && comparator.compare(array[j - gap], temp) < 0; j -= gap) {
                        array[j] = array[j - gap];
                    }
                    array[j] = temp;
                }
            }
        }
    }

