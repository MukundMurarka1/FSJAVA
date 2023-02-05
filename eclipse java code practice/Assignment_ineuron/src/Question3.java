
public class Question3 {

	public static void main(String[] args) {
		int number =15;
		for (int i=0;i<number;i++) {
			for (int j=0;j<number;j++) {
				if(i==0 || j==0 || i==number-1|| j==number-1 || i+j <= (number-1)/2 ||j-i >= (number-1)/2)  {
					
					System.out.print("*");
				} 
				else 
				{
					System.out.print(" ");
				}
				
			}
			System.out.println("");
		}
		

	}

}
