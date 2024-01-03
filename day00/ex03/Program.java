package ex03;

import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numWeek = 1;
		int minWeek = 0;
		long graph = 0;
		String input = scanner.nextLine();
		int i = 1;
		while(!input.equals("42") && numWeek <= 18) {
			if(input.equals("Week " + numWeek)) {
				minWeek = takeMin(scanner);
				graph = wrapNum(minWeek,graph,numWeek);
			}
			else {
				System.exit(illegalArgument());
			}
			numWeek++;
			input = scanner.nextLine();
		}
		while(i < numWeek) {
			System.out.print("Week " + i + " ");
			putGraph(unwrapNum(i,graph));
			i++;
		}
		scanner.close();
	}

	public static int digitSum(int number) {
		int sum = 0;
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static boolean isPrime(int number) {
		int i = 1;
			while(i++ < (number / 2)) {
				if(number % i == 0) {
					return false;
				}
			}
			return true;
	}

	public static int takeMin(Scanner scanner) {
		int n;
		int i = 0;
		int min = 10;
		while(++i <= 4) {
			n = scanner.nextInt();
			if(n < min) {
				min = n;
			}
		}
		scanner.nextLine();
		return min;
	}

	public static long wrapNum(int minWeek, long graph, int numWeek) {
		long ret;
		long powTen = 1;
		int i = 1;
		while(i < numWeek) {
			powTen *= 10;
			i++;
		}
		ret = graph + (minWeek * powTen);
		return (ret);
	}

	public static int unwrapNum(int index,long graph) {
		int ret;
		int i = 1;

		while(i < index) {
			graph /= 10;
			i++;
		}
		ret = (int)(graph % 10);
		return (ret);
	}

	public static void putGraph(int grade) {
		int i = 0;
		while(i++ < grade) {
			System.out.print("=");
		}
		System.out.println(">");
	}

	public static int illegalArgument() {
		System.out.println("Illegal Argument");
		return -1;
	}
  }

