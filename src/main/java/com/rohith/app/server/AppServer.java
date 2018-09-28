package com.rohith.app.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class AppServer {

	private Server server;
	
	private static int DEFAULT_PORT =8080;
	
	public AppServer(int port){
		
		this.server = new Server(port);
	}
	
	public AppServer(){
		
		this.server = new Server(DEFAULT_PORT);
	}
	
	
	public void startServer() throws Exception{
	  ServletContextHandler ctx = 
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ctx.setContextPath("/");
        server.setHandler(ctx);
        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/app/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("com.sun.jersey.config.property.packages", 
                "com.rohith.app.service");
        server.start();
	}
	
	
	public void join(){
		
		if(null!=this.server&&this.server.isStarted()){
			
			try {
				this.server.join();
			} catch (InterruptedException e) {
				System.out.println("Exception while Joining server" + e.getMessage());
			}
		}
	}
	
	
	public void stopServer(){
		
		if(null!=this.server&&this.server.isStarted()){
			
			try {
				this.server.stop();
			} catch (Exception e) {
			
				System.out.println("Exception while stopping server hence destroying it" + e.getMessage());
				
				this.server.destroy();
			}
		}
	}
	
	
}
