import java.util.ArrayList;
import java.util.List;

class ThreadsMonitor{
	private int []array;
	private int arraySize;
	private int threadsCount;
	private List<Integer> sumByThreads;
	private List<MyThread> MyThreads;

	public ThreadsMonitor(int[] array ,int arraySize, int threadsCount){
		this.array = array;
		this.arraySize = arraySize;
		this.threadsCount = threadsCount;
		this.sumByThreads = new ArrayList<Integer>();
		MyThreads = generateThreadList();
		startThread();
		try {
			join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private List<MyThread> generateThreadList(){
		List<MyThread> MyThread = new ArrayList<MyThread>();
		int cells = arraySize/threadsCount;
		int start = 0;
		int end = cells - 1;
		for(int i=0;i < threadsCount; i++){
			if(i == threadsCount - 1){
				end = arraySize - 1;
			}
			MyThread.add(new MyThread(i,array, start, end, sumByThreads));
			start+=cells;
			end+=cells;
		}
		return MyThread;
	}

	private void startThread(){
		for(MyThread t : this.MyThreads){
			t.start();
		}
	}

	public void	join() throws InterruptedException {
		for (Thread t : this.MyThreads) {
			t.join();
		}
	}

	public int getSumByThreads() {
		int sum = 0;
		for(int ret : this.sumByThreads){
			sum += ret;
		}
		return sum;
	}
}
