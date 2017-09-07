package utility;


import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
	Constants cs = new Constants();

	public static void main(String[] args) {

		TestClass tc = new TestClass();

		// System.out.println("Hello");
		// System.out.println("World");
		// tc.arithmetic();
		/// tc.looper();
		System.out.println("+++++++++++++++++++++++++");
		// tc.inputFormAndTest();
		// tc.arrayTest();
		// tc.backwardName();
	//	 tc.uppercaseChecker();
		//tc.listTest();
		tc.caseChecker();

	}

	public void arithmetic() {

		System.out.println("this is an int = " + cs.x);
		System.out.println("this is a double = " + cs.a);

		int sumOfInt = cs.x + cs.y;
		double sumOfDouble = cs.a + cs.b;
		double sumOfIntAndDouble = cs.x + cs.a;
		System.out.println("sum int " + sumOfInt);
		System.out.println("sum double " + sumOfDouble);
		System.out.println("int and double " + sumOfIntAndDouble);

	}

	public void looper() {

		for (int i = 0; i <= 10; i++) {
			for (int j = 10; j >= i; j--) {
				System.out.print(" ");
				j--;
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("x");
			}
			System.out.println();
			i++;
		}

	}

	public void inputFormAndTest() {
		int grade = 0;
		int x = 1;
		String loopend = null;
		while (x > 0) {
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter grade: ");
			String input = reader.nextLine();
			if (!input.matches("\\d+")) {
				loopend = input;
				if (loopend.equals("mice")) {
					System.out.println("data has been done");
					System.exit(0);
				}

				System.out.println("Input should be intergers only");
			}
			if (input.matches("\\d+")) {
				grade = Integer.parseInt(input);

				if (grade == 100) {
					System.out.println("perfect score big boy");
				}

				else if (grade <= 99 && grade >= 90) {
					System.out.println("Asian kiddo ");
				}

				else if (grade <= 89 && grade >= 75) {

					System.out.println("Semi goodie");
				}
				if (grade <= 74 && grade >= 60) {
					System.out.println("what a waste of effort and time  ");

				} else if (grade <= 59 && grade >= 0) {
					System.out.println("YO! next time tho, next time  ");

				} else {
					System.out.println("invalid input ");
				}

			}

		}
	}

	public void arrayTest() {
		int ages[] = new int[cs.ARRAY_SIZE];
		String name[] = new String[cs.ARRAY_SIZE];
		ages[0] = 10;
		ages[49] = 22;
		name[10] = "hdro";

		for (int i = 0; i < name.length; i++) {
			System.out.println("ages " + name[i]);
		}
		for (int i = 0; i < ages.length; i++) {
			System.out.println("ages " + ages[i]);
		}

	}

	public void backwardName() {
		int j = 0;

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter name: ");
		String inputName = reader.nextLine();
		char[] cArray = inputName.toCharArray();

		j = cArray.length - 1;
		for (int i = 0; i < cArray.length; i++) {
			System.out.print(cArray[j]);
			j--;

		}
	}

	public void uppercaseChecker() {
		char[] x = new char[cs.ARRAY_SIZE];
		Scanner reader = new Scanner(System.in);

		System.out.println("Enter name: ");
		String name = reader.nextLine();
		int count = 0;
		int z = name.length();

		for (int i = 0; i < z; i++) {

			if (Character.isUpperCase(name.charAt(i))) {
				x[count] = name.charAt(i);
				count++;
			}
		}

		for (int i = 0; i < x.length; i++) {

			if (x[i] != '\0') {
				System.out.print(x[i]);
			}
		}
	}

	public void listTest() {
		ArrayList al = new ArrayList();

		System.out.println(al.size());

	}

	public void caseChecker() {
	
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter grade: ");
		String input = reader.nextLine();
		String grade = input;
		
		switch (grade) {
		case "holy":
			System.out.print("first");
			break;
		case "90":
			System.out.print("second");
			break;
		case "80":
			System.out.print("3rd");
			break;
		case "70":
			System.out.print("4th");
			break;
		default:
			System.out.print("break");
			break;
		}

	}

}
