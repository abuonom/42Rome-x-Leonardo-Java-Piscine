package ex00;
class Main {
	public static void main(String[] args) {
		int number = 479598;
		int sum = 0;
		int i = -1;
		while(++i <= 5) {
			sum += number % 10;
			number /= 10;
		}
	  System.out.println(sum);
	}
  }
