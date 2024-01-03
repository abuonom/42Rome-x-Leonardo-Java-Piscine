public class Program {
	static String[] countString;
	static int count;

	public static void main(String args[]) {
		if (args[0].contains("--count=")) {
			countString = args[0].split("=");
			count = Integer.parseInt(countString[1]);
		}else{
			System.err.println("Enter correct input: ");
			System.exit(-1);
		}
		MyThread egg = new MyThread("egg", count);
		MyThread han = new MyThread("han", count);
		Program human = new Program(count);

		egg.start();
		han.start();

		try {
			egg.join();
			han.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < count; i++) {
			System.out.println("Human");
		}
	}

	public Program(int count) {
		this.count = count;
	}
}
