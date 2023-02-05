
public class SalectionSort {

	public static void main(String[] args) {
		
		int[] arr = {10,15,1,5,3,8};
		
		selectionSort(arr);
		

	}

    public static void selectionSort(int [] arr) {
    	int index = arr.length;
    	
    	for (int i=0;i<arr.length-1;i++) {
    		int min_ind = i;
    		
    		for(int j=i+1;j<arr.length;j++) {
    			if(arr[j] <arr[min_ind]) {
    				min_ind = j;
    			}
    		}
    		
    		int temp = arr[min_ind];
            arr[min_ind] = arr[i];
            arr[i] = temp;
    	}
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] +" ");
    	}
		// TODO Auto-generated method stub
		
	}

	

}
