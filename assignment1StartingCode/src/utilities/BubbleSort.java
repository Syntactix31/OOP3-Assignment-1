/**
 * 
 */
package utilities;
/**
 * 
 */
public class BubbleSort {

	/**
	 * 
	 */
	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(double[] testArray) {
		
		for (int i=0; i < testArray.length; i++) {
			for (int j=1; j<testArray.length - i; j++) {
				if (testArray[j] > testArray[j - 1]) {
					swap(testArray, j, j-1);
				}
			}
		}
	}	
	
	
	private void swap(double[] testArray, int index1, int index2) {
		double temp = testArray[index1];
		testArray[index1] = testArray[index2];
		testArray[index2] = temp;
	}
		

	
    public static void main(String[] args) {
        BubbleSort sortArray = new BubbleSort();
        
        double[] testArray = {15.445, 8.234, 5.679, 5.78, 11.3};
        System.out.println("Original Array: ");
        
        for (double val : testArray) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        sortArray.sort(testArray);
        
        for (double numbers : testArray) {
            System.out.println(numbers);
        }
        
//      Non formatted output:  System.out.println(Arrays.toString(testArray));
        
    }
    
    
	
}
