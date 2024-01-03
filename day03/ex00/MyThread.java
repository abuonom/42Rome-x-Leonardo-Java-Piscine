class MyThread extends Thread {
	private String name;
	private int count;

	public MyThread(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}
}
