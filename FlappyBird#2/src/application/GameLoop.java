package application;

public class GameLoop extends Thread{

	public void run() {
		
		while(true) {
			
			//Gravity
			if(Main.gravity == true) {
				
				if(Main.spaceBar == true) {
					
				}else {
					
					Main.iv.setY(Main.iv.getY()+4);
					try {
						Thread.sleep(32);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			
			}
			
			//Space Bar Pressed
			if(Main.spaceBar == true) {
				
				Main.gravity = false;
				
				for(int i = 0; i < 8; i++) {
					
					Main.iv.setY(Main.iv.getY()-12);
					try {
						Thread.sleep(32);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					i++;
					
				}
				
				Main.spaceBar = false;
				Main.gravity = true;
				
			}
		
			//If Overlap
			
			for(int i = 0; i < Main.walls.size(); i++) {
				
				boolean intersects = Main.walls.get(i).intersects(Main.iv.getBoundsInParent());
				
				if(intersects == true) {
					Main.iv.setFitWidth(Main.iv.getFitWidth()+2);
					Main.iv.setFitHeight(Main.iv.getFitHeight()+2);
				}
				
			}
			
			
		}
		
	}
	
}
