package utilities;

public class InsertionSort {

   
    public InsertionSort() {}

    /* @param testArray */
    public void sort(double[] testArray) {
        for (int i = 1; i < testArray.length; i++) {
            double key = testArray[i];
            int j = i - 1;

            // Compares and shifts larger nums forward
            while (j >= 0 && testArray[j] < key) {
                testArray[j + 1] = testArray[j];
                j--;
            }

            testArray[j + 1] = key;
        }
    }

    /* test array */
    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
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
