package ex02;

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		int coffe = 0;
		while(number != 42) {
			if(isPrime(digitSum(number))) {
				coffe++;
			}
			number = scanner.nextInt();
		}
		System.out.println("Count of coffee - request - " + coffe);
		scanner.close();
	}

	public static int digitSum(int number){
		int sum = 0;
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static boolean isPrime(int num) {
		int sqrt = 0;

		if (num <= 1) {
			return (false);
		} else if (num == 2) {
			return (true);
		}
		sqrt = mySqrt(num);
		for (int i = 2; i <= sqrt + 1; i++) {
			if (num % i == 0) {
				return (false);
			}
		}
		return (true);
	}

	public static int mySqrt(int x) {
		if (x == 0) return 0;
		long i = x;
		while(i > x / i)
			i = (i + x / i) / 2;
		return (int)i;
	}
  }

