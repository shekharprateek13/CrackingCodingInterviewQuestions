package dsalgoproblems.scheduler.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	
	private int i = 10;
	
	@Override
	public void run(){
		System.out.println("Timer task 1 started at:"+new Date());
		completeTask();
		System.out.println("Timer task 1 finished at:"+new Date());
	}

	private void completeTask(){
		try{
			Thread.sleep(20000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void loadDataFromDB() throws SQLException {
	    
	    try (Connection dbCon = DriverManager.getConnection("url", "user", "password");
	    		ResultSet rs = dbCon.createStatement().executeQuery("select * from emp")) {
	        while (rs.next()) {
	            System.out.println("In loadDataFromDB() =====>>>>>>>>>>>> " + rs.getString(1));
	        }
	    } catch (SQLException e) {
	        System.out.println("Exception occurs while reading the data from DB ->" + e.getMessage());
	    } /*finally {
	        if (null != dbCon)
	            dbCon.close();
	    }*/
	}

	public static void main(String args[]){
		Class<?> timerClass = MyTimerTask.class;
		timerClass = new MyTimerTask().getClass();
		try {
			timerClass = Class.forName("MyTimerTask");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Map<String,String> map = new HashMap<String,String>();
		//If the specified key is not already associated with a value (or is mapped to null) associates 
		//it with the given value and returns null, else returns the current value.
		
//		map.put
		
		/*
		TimerTask timerTask = new MyTimerTask();
		//running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		timer.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				System.out.println("Timer task 2 started at:"+new Date());
				completeTask();
				System.out.println("Timer task 2 finished at:"+new Date());
			}
			
			private void completeTask(){
				try{
					Thread.sleep(30000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		},0, 20*1000);
		System.out.println("TimerTask started");
		try{
			Thread.sleep(120000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}