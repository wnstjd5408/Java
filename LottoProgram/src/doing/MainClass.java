package doing;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Control c = new  Control();
		System.out.print("몇장 살것인가요?");
		int count = sc.nextInt();
		c.run(count);
		
		sc.close();
	}
}
