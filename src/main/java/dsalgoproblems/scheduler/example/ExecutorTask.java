package dsalgoproblems.scheduler.example;

public class ExecutorTask implements Runnable {
	
	private String threadName;
	
	public ExecutorTask(String s){
		this.threadName = s;
	}

	public void run(){
		for(int i = 0; i < 10; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread Name: "+this.threadName+"; Frequency: "+i);
		}
	}
}