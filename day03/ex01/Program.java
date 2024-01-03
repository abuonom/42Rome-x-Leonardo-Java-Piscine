public class Program extends Thread {
	static int count;

	public static void main(String args[]) {
		if (args[0].contains("--count=")) {
			String [] countString = args[0].split("=");
			count = Integer.parseInt(countString[1]);
		}else{
			System.err.println("Enter correct input: ");
			System.exit(-1);
		}
		Object lock = new Object();
		MyThread egg = new MyThread("egg", count,lock);
		MyThread han = new MyThread("han", count,lock);

		egg.start();
		han.start();

		try {
			egg.join();
			han.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
