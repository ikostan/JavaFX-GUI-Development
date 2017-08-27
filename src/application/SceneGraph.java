package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class SceneGraph extends Application{

	private final static String TAG = SceneGraph.class.getName();
	private final static String mNAME = "Method name: ";
	private final String TITLE = "JavaFX: Scene Graph Example";

	
	@Override
	public void start(Stage primaryStage) throws Exception {

		printLog("start", "started");
		
		StackPane root = new StackPane();
		
		//Add a leaf node
		Circle cir = new Circle(200,200,100);
		cir.setFill(Color.CORAL);
		root.getChildren().add(cir);
		
		//Start a new Scene
		Scene scene = new Scene(root, 400, 400);
		
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {

		printLog("main", "started");
		launch(args);
	}	
	
	
	private static void printLog(String method, String action){
		
		System.out.println(TAG + " >>> " + mNAME + method + " >>> " + action);
	}

}
