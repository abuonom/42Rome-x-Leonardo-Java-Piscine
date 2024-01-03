class MyThread extends Thread {
	private String name;
	private int count;
	private Object lock;

	public MyThread(String name, int count, Object lock) {
		this.name = name;
		this.count = count;
		this.lock = lock;
	}

	public void  run() {
		synchronized (lock){
			for (int i = 0; i < count; i++) {
				System.out.println(name);
				lock.notify();
				try{
					lock.wait();
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			lock.notify();
		}
	}
}
