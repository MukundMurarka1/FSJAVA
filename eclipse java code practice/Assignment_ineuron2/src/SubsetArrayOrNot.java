
public class SubsetArrayOrNot {
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50,60};
		int[] arr2 =  {20,30, 50};
		int count=0;
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i] == arr2[j]) {
					count= count+1;
				}
			}
		}
		if(count==0) {
			System.out.println("second Array is not subset of first array ");
		}
		else {
			System.out.println("Second Array is subset of first array ");
		}
	}

}
