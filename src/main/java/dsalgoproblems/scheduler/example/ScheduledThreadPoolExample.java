package dsalgoproblems.scheduler.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledThreadPoolExample {

	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		
		ExecutorTask task1 = new ExecutorTask("Thread 1");
		ExecutorTask task2 = new ExecutorTask("Thread 2");
		ExecutorTask task3 = new ExecutorTask("Thread 3");
		
//		pool.schedule
	}
}