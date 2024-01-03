import java.util.Random;

public class Program extends Thread {
	static int arraySize;
	static int threadsCount;
	static int array[];

	public static void main(String args[]) {
		Random random = new Random();
		if(args.length != 2){
			System.err.println("Inserire input corretto");
			System.exit(-1);
		}
		if (args[0].contains("--arraySize=") && args[1].contains("--threadsCount=")) {
			String [] countString = args[0].split("=");
		try {
			arraySize = Integer.parseInt(countString[1]);
			countString = args[1].split("=");
			threadsCount = Integer.parseInt(countString[1]);
			} catch (NumberFormatException e) {
				System.out.println("Error: not a number");
				System.exit(-1);
		}=
		}else{
			System.err.println("Enter correct input: ");
			System.exit(-1);
		}
		if(threadsCount > arraySize || arraySize > 2_000_000){
			System.err.println("Enter correct input: ");
			System.exit(-1);
		}
		array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(10) + 1;
		}
		System.out.println("Sum: " + Program.sumOfElements(array,arraySize));
		try {
			ThreadsMonitor threadsMonitor = new ThreadsMonitor(array,arraySize,threadsCount);
			System.out.println("Sum by threads: " + threadsMonitor.getSumByThreads());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public static int sumOfElements(int array[],int arraySize){
		int somma=0;
		for(int i=0; i<arraySize; i++) {
			somma=somma+array[i];
		}
		return somma;
	}
}


// $ java Program --arraySize=13 --threadsCount=3
// Sum: 13
// Thread 1: from 0 to 4 sum is 5
// Thread 2: from 5 to 9 sum is 5
// Thread 3: from 10 to 12 sum is 3
// Sum by threads: 13
