
public class DuplicateElement {

	public static void main(String[] args) {
		
		int[] arr1 = {10,20,30,40,10,30};
		int len = arr1.length;
		int k=0;
		
		
		for (int i=0;i<len;i++) {
			
			for (int j=i+1;j<len;j++) {
				if (arr1[i] == arr1[j]) {
					System.out.print(arr1[j] + " ");
					k= k+1;
						
				}
			}
			
		}
		System.out.println();
		System.out.println("number of duplicate element is " +k);
		
		
		

	}

}
