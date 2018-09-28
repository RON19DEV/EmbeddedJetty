package com.rohith.app;

import com.rohith.app.server.AppServer;

public class AppEntry {
	
	
	private AppServer appServer;
	
	private Thread starterThread;
	
	public static void main(String[] args){
		
		
		AppEntry entry  = new AppEntry();
		
		try {
			
			if(entry.startApp(args)){
				Runtime.getRuntime().addShutdownHook(new Thread(new ExitMonitor(entry)));
				entry.starterThread = Thread.currentThread(); 
				entry.joinServer();
			}else{
				throw new RuntimeException("Starting app Failed");
			}
		} catch (Exception e) {
			throw new RuntimeException("Starting app Failed" + e.getMessage());
		}
		
	
	}
	
	
	public void joinServer(){
		
		this.appServer.join();
	}
	
	
	public boolean startApp(String[] args) throws Exception{
		
		
		if(args.length==0){
	
			return false;
		}
		
		int port = Integer.parseInt(args[0]);
		
		
		this.appServer = new AppServer(port);
		
		this.appServer.startServer();
		
		
		return true;
	}
	
	public void stop(){
		if(null!=this.appServer){
			this.appServer.stopServer();
		}
		
	}

	
	private static class ExitMonitor implements Runnable{

		private AppEntry entry;
		
		public ExitMonitor(AppEntry entry){
			
			this.entry=entry;
		}
		
		public void run() {
		
			
			this.entry.stop();
			
			if(null!=entry.starterThread && !entry.starterThread.isInterrupted()){
				entry.starterThread.interrupt();
			}
			
		}
		
		
		
	}
	
}
