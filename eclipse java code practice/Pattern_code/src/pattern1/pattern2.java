package pattern1;

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		char value = sc.next().charAt(0);
		
		if(Character.isUpperCase(value)) {
			System.out.println(1);
		}else if(Character.isLowerCase(value)) {
			System.out.println(0);
		}else {
			System.out.println(-1);
		}
		// TODO Auto-generated method stub

	}

}
