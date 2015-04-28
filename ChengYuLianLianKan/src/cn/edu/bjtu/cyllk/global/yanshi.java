package cn.edu.bjtu.cyllk.global;

public class yanshi extends Thread {
	private int time = 0;

	public yanshi(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		super.run();
		try {
			sleep(this.time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
