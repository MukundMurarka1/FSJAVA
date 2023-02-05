
public class Firstproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 10;
		
		for (int i=0;i<n;i++) {
			// code for I 
			for (int j=0;j<n;j++) {
				if((i==0 && j<= (3*n)/4) || (i==n-1 && j<= (3*n)/4) || j== (3*n)/8 ) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			// code for N
			for (int j=0;j<n;j++) {
				if(j==0 || j== (3*n)/4 || i==(4*j)/3 ) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			// code for E 
			for (int j=0;j<n;j++) {
				if(j==0 ||(i==0 && j<= (3*n)/4) |(i==n-1 && j<= (3*n)/4)|| (i==(n-1)/2 && j<= (3*n)/4)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			// code for U
			
			for (int j=0;j<n;j++) {
				if((j==0 && i< n-1)||(j==(3*n)/4 && i<n-1)||(i==n-1 && j>0 && j<n-1 && j<(3*n)/4)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			// CODE for R 
			for(int j=0;j<n;j++) {
				if(j==0 || (i==0 && j<(3*n)/4) || (j == (3*n)/4 && i>0 && i<n/2) || (i==n/2 && j < (3*n)/4) ||(i>n/2) && i== (4*j)/3) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			// code for O
				for (int j=0;j<n;j++) {
					if((i==0 && j<(3*n)/4 && j>0) || (i==n-1 && j<(3*n)/4 && j>0) || (j==0 && i>0 && i<n-1 )|| (j==(3*n)/4 && i>0 && i<n-1)) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}			
			// code for N
				for (int j=0;j<n;j++) {
					if(j==0 || j== (3*n)/4 || i==(4*j)/3 ) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			System.out.println("");
		}
	}

}
