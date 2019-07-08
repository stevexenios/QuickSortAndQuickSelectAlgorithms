
/**
 * QuickSort and QuickSelect Algorithm Using Lomuto Partioning.
 * NOTE: Not optimized for equal values in arrays.
 * @author Steve Mwangi
 * @version TCSS Practice
 */
public class QuickSortAndQuickSelectAlgorithm {
	
	/**
	 * By definition, Arrays are Mutable in java. 
	 * Therefore we use clone, to show how each method/call 
	 * affects the array. 
	 */
	static final String[] arrS = {"1-st", "2-nd", "3-rd", "4-th", "5-th","6-th", "7-th", "8-th"};
	static final int[] arr = {1000, 43, 7, 13, 9, 90, 23, 89, 2, 4, 11};
	static final int[] arr1 = arr.clone();
	static final int[] arr2 = arr.clone();
	static final int[] arr3 = arr.clone();
	static final int[] arr4 = arr.clone();
	static final int[] arr5 = arr.clone();
	
	
	
    public static void main(String[] args) {
    	
        System.out.println("BEFORE: The List of Numbers: ");
        for(int i = 0; i< arr.length; i++) {
        	if(i!=arr.length-1) {
        		System.out.print(arr[i] + " ");
        	}else {
        		System.out.print(arr[i]);
        	}
        }
        
        System.out.println();
        System.out.println();
	    System.out.println("QuickSort Algorithm at Work:");
	    QuickSort(arr1, 0, arr.length-1);
	      
        
    	System.out.println();
        System.lineSeparator();
        System.out.println("QuickSelect Algorithm at Work: ");
    	QuickSelect(arr1, 0, arr1.length-1, 0);
        QuickSelect(arr2, 0, arr2.length-1, 1);
        QuickSelect(arr3, 0, arr3.length-1, 2);
        QuickSelect(arr4, 0, arr4.length-1, 4);
        QuickSelect(arr5, 0, arr5.length-1, 6);
        
        System.out.println("AFTER: The List of Numbers: ");
        for(int i = 0; i< arr.length; i++) {
        	if(i!=arr.length-1) {
        		System.out.print(arr[i] + " ");
        	}else {
        		System.out.print(arr[i]);
        	}
        }
        
    }



    public static void QuickSelect(int[] A, int start, int end, int k) {
    	int pivotIndex = lomutoPartioning(A, start, end);
    	if(k==pivotIndex) {
    		System.out.println("The " + arrS[k] + " smallest item is: ");
			System.out.println(A[k]);
    	} else {
    		if(k>pivotIndex) {
    			QuickSelect(A, pivotIndex+1, end, k);
    		} else if(k<pivotIndex) {
    			QuickSelect(A, start, pivotIndex-1, k);
    		}
    	}
    	
    }

    public static int lomutoPartioning(int[] A, int start, int end){
        int pivot = A[end];
        int pivotIndex = 0;
        for(int i = 0; i<end; i++){
            if(A[i]<pivot){
                int alpha = A[pivotIndex];
                A[pivotIndex] = A[i];
                A[i] = alpha;
                pivotIndex++;
            }
        }
        int beta = A[pivotIndex];
        A[pivotIndex] = pivot;
        A[end] = beta;
        
        return pivotIndex; 
    }
    
    public static void QuickSort(int[] A, int start, int end){
        if(start<end){
            int pivot = lomutoPartioning(A, start, end);
            for(int j = 0; j< A.length; j++){
                if(j==A.length-1){
                    System.out.print(A[j]);
                    System.out.println();
                } else{
                    System.out.print(A[j] + " ");
                }
            }
            QuickSort(A, start, pivot-1);
            QuickSort(A, pivot+1, end);
        }

    }

    
}

