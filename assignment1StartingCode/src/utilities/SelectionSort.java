package utilities;

/**
 * 
 */
public class SelectionSort {

	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(double[] Array) {
		// TODO Auto-generated method stub
		
		for(int i=0; i < Array.length - 1; i++) {
			
			int max = i;
			
			for(int j=i+1; j < Array.length; j++) {
				if(Array[j] > Array[max])
				max = j;
			}
			
			if (max != i) {
				swap(Array, max, i);
			}
		}
		
		
	}
	
	private void swap(double[] array, int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}
	
	
    public static void main(String[] args) {
        SelectionSort sortArray = new SelectionSort();
        
        double[] testArray = {15.445, 8.234, 5.679, 5.78, 11.3, 8.234};
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
    }
    


}


