package utilities;

public class ShellSort {

    public ShellSort() {}

    /* @param testArray */
    public void sort(double[] testArray) {
        int n = testArray.length;

        // gap sorting part 1 start with a large gap then make it smaller
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // gap sorting part 2 do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                double temp = testArray[i];
                int j;

                // descending order
                for (j = i; j >= gap && testArray[j - gap] < temp; j -= gap) {
                    testArray[j] = testArray[j - gap];
                }

                testArray[j] = temp;
            }
        }
    }

    
    /* test array */
    public static void main(String[] args) {
        ShellSort sorter = new ShellSort();
        double[] testArray = {15.445, 8.234, 5.679, 5.78, 11.3};
        
        System.out.println("Original Array:");
        for (double val : testArray) {
            System.out.println(val);
        }

        sorter.sort(testArray);

        System.out.println("\nSorted Array (Descending):");
        for (double val : testArray) {
            System.out.println(val);
        }
    }
}
