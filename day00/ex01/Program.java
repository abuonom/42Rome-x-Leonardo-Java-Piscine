package ex01;

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		boolean input = true;
		boolean flag = true;
		int i;
		int sqrt = mySqrt(number);
		int step = 0;
		int exit_code = 0;
		if(number > 1) {
			input = false;
			if(number == 2){
				flag = true;
				step++;
			}
			else
			{
				for(i = 2; i <= (sqrt + 1) ; i++) {
					if(number % i == 0) {
						step++;
						flag = false;
						break;
					}
					step++;
				}
			}
			if(!flag && !input) {
				System.out.println("false " + step);
			}
			else {
				System.out.println("true " + step);
			}
		}
		if(input == true) {
			System.err.println("Illegal Argument");
			exit_code = -1;
			scanner.close();
			System.exit(-1);
		}
		scanner.close();
		System.exit(exit_code);
	}

	public static int mySqrt(int x) {
		if (x == 0) return 0;
		long i = x;
		while(i > x / i)
			i = (i + x / i) / 2;
		return (int)i;
	}
  }
