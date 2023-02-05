import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		int len = arr.length;
				
		bubbleSort(arr,len);
		System.out.println(Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr, int len) {
		int temp;
		int len1 = arr.length;
		int count=0;
		for(int i = 0;i<len-1;i++ ) {
			if (arr[i] > arr[i+1]) {
				temp =arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				count = count+1;
				
			}
		}
		if (count == 0)
            return;
		bubbleSort(arr,len-1);
		
	}

}
