package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button btn = new Button();
		btn.setText("Say 'Hello World!'");
		btn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Hello World!");
				primaryStage.setTitle("Hello World!");
			}
		});
		
		StackPane pane = new StackPane();
		pane.getChildren().add(btn);	
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
