import java.util.Arrays;

class Question1 {
	
			

	public static void main(String[] args) {
		int[] arr = {9,8,7,6,1,3,2};
		arr = mergesort(arr);
		System.out.println(Arrays.toString(arr));
		

	}
	
	
	 static int[] mergesort(int[] arr) {
			if(arr.length == 1) {
				return arr;
			}
				int mid = (arr.length)/2;
			int[] firstarray = mergesort(Arrays.copyOfRange(arr, 0, mid));
			int[] secondarray = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
			return merge(firstarray, secondarray);
			}
			
		

		 private static int[] merge(int[] arr1, int[] arr2) {
			
			int[] newarray = new int[arr1.length + arr2.length];
			int i = 0;
			int j=0;
			int k = 0; 
			while(i < arr1.length && j < arr2.length) {
				if(arr1[i] < arr2[j] ) {
					newarray[k]=arr1[i];
					i++;
				}
				else {
					newarray[k] = arr2[j];
					j++;
					
				}
				
				
				k++;
			}
			
			while(i < arr1.length) {
				newarray[k] = arr1[i];
				i++;
				k++;
				
			}
			
			while(j < arr2.length) {
				newarray[k] = arr1[j];
				j++;
				k++;
				
			}	
			
			
			return newarray;
		}
	 


}





//copy of one array into two sub array 
//for(int i =0; i<mid;i++) {
//firstarray[i] = arr[i];
//}
//for(int i =0; i<mid;i++) {
//secondarray[i] = arr[mid+i];
//}
//System.out.println(Arrays.toString(firstarray));
//System.out.println(Arrays.toString(secondarray));
//
//firstarray  = mergesort(firstarray);
//secondarray = mergesort(secondarray);

