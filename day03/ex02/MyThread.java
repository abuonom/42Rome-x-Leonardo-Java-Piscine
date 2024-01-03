import java.util.List;

class MyThread extends Thread {
	private int index;
	private int array[];
	private int start;
	private int end;
	private int sum;
	private List<Integer> sumByThreads;

	public MyThread(int index,int [] array, int start, int end, List<Integer> sumByThreads) {
		this.array = array;
		this.start = start;
		this.end = end;
		this.sumByThreads = sumByThreads;
		this.index = index;
		this.sum = 0;
	}

	public void  run() {
		for(int i = this.start; i < this.end + 1; i++){
			//System.out.println("IL thread " + (index + 1) + "sta controllando Array pos: " + i);
			this.sum += array[i];
		}
		System.out.println("Thread "+ (index+1) + ": from "+ start + " to " + this.end + " sum " + " is " + sum);
		sumByThreads.add(sum);
	}
}
