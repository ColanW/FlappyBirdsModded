package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	//Boolean Flips
	
	public static boolean spaceBar = false;
	public static boolean gravity = true;
	
	//Image
	public static ImageView iv = new ImageView("application/bird.png");
	
	//Walls Array
	public static ArrayList<Rectangle> walls = new ArrayList<Rectangle>();

	//Beginning Arguments
	public static BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Beginning Arguments
			Scene scene = new Scene(root,1280,720);
			
			//Main Scene
			
			//Image
			iv.setFitWidth(32);
			iv.setFitHeight(32);
			iv.setLayoutY(132);
			iv.setLayoutX(132);
			
			root.getChildren().add(iv);
			
			//End Image
			
			//Space Bar
			scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
				
	            if (event.getCode() == KeyCode.SPACE) {
	            	
	            	spaceBar = true;
	            	
	            }
			 
	        });
			 
			//Ending Arguments
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Starting Game Loop
			
			GameLoop gl = new GameLoop();
			gl.start();
			
			Walls w = new Walls();
			w.start();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	public static void CreateWall(){
		
		//Creating Walls
		Rectangle r = new Rectangle();
		Rectangle r2 = new Rectangle();
		
		r.setWidth(32);
		r2.setWidth(32);
		
		int h = 500;
		int h1;
		int h2;
		
		Random rand = new Random();

		int n = rand.nextInt(400);
		n++;
		
		h1 = n;
		h2 = 500-n;
		
		r.setHeight(h1);
		r2.setHeight(h2);
		
		r.setX(1000);
		r2.setX(1000);
		
		r.setY(0);
		
		r2.setY(720-h2);
		
		 root.getChildren().add(r);
		 root.getChildren().add(r2);
		
		 while(walls.size()>=10) {
			 walls.remove(0);
		 }
		 
		 walls.add(r);
		 walls.add(r2);
		
	}
	
	
	
}
