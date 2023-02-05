import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr1 = {5,4,3,2,1,6};
		 sortedArray(arr1, 0, (arr1.length-1));
		 System.out.println(Arrays.toString(arr1));
	

	}
	
	static void sortedArray(int[] arr, int low, int high) {
		if (low >= high) {
			return;
			
		}
		int s = low;
		int e= high;
		int mid = s+ (e-s)/2;
		int pivot = arr[mid];
		
		while( s<=e) {
			while (arr[s] < pivot) {
				s++;
			}
			while(arr[e] > pivot) {
				e--;
			}
			
			if(s<=e) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
			
		}
		sortedArray(arr, low,e);
		sortedArray(arr, s, high);
	}

}
