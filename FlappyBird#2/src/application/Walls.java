package application;

import javafx.application.Platform;

public class Walls extends Thread{

	public void run() {
		
		int x = 0;
		
		while(true) {
			
			
			
			//Walls Slidding
			for(int i = 0; i < Main.walls.size(); i++) {
				
				Main.walls.get(i).setX(Main.walls.get(i).getX()-5);
				
			}

			
		
			if(x == 60) {
				x = 0;
				
				Platform.runLater(() -> {
					
				Main.CreateWall();
				
				});
				
			}else {
				try {
					Thread.sleep(25);
					x++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
