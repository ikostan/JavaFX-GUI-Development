package application;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application{

	//Final parameters
	private final static String TAG = Main.class.getName().replaceAll("application.", "");	
	private final String ERROR = "Error Dialog";
	private final String EXCEPTION = "An exception occured, see description below:";
	private final String ERRORHEAD = "An error occured, see description below:";
	private final String btnName = "LAUNCH";
	private final String JAR = ".jar";
	private final String exeFolder = "\\src\\executable";
	private final double WIDTH = 300; 
	private final double HEIGHT = 200;

	//GUI objects
	private Scene scene;
	private BorderPane pane;
	private Button btnLaunch;
	private ComboBox combo;
	
	//Run time parameters
	private File[] fileArray;
	private File rootFolder;
	private String rootFolderPath;
	private Path path;
	
	
	//Main method
	public static void main(String[] args) {

		System.out.println(TAG + ": main method called");
		launch(args);
	}

	
	@Override
	public void start(Stage mainStage) throws Exception {
		
		System.out.println(TAG + ": start method called");		
					
		pane = new BorderPane();
		setCombo();
		setBtn();		
		scene = new Scene(pane, WIDTH, HEIGHT);
		setStage(mainStage);
	}
	
	//Set 'Launch' button
	private void setBtn(){
		
		System.out.println(TAG + ": setBtn method called");		
		
		btnLaunch = new Button();
		btnLaunch.setText(btnName);
		btnLaunch.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				//TODO:
				if(combo.getValue() != null){
					
					String fileName = combo.getValue().toString();
				}
				else{
					 
					String error = "The list is empty. There is nothing to process.";
					System.out.println(TAG + ": " + error);	
					showError(error);
				}				
			}
		});	
		pane.setBottom(btnLaunch);
	}

	//Set main stage
	private void setStage(Stage mainStage){
		
		System.out.println(TAG + ": setStage method called");		
		
		mainStage.setTitle(TAG);
		mainStage.setScene(scene);	
		//mainStage.setAlwaysOnTop(true);
		mainStage.show();
		
		//Set window in the center of the screen:
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		mainStage.setX((screenBounds.getWidth() - mainStage.getWidth()) / 2); 
		mainStage.setY((screenBounds.getHeight() - mainStage.getHeight()) / 2);  
	}
	
	//Set combo box
	private void setCombo(){
		
		System.out.println(TAG + ": setCombo method called");		
		
		combo = new ComboBox(); //Create a new Combo Box
		scanDirectory();
		
		if(fileArray.length > 0){
			
			ArrayList<String> names = new ArrayList<>();
			
			for(File file : fileArray){
				
				if(file.toString().contains(JAR)){
					
					names.add(file.getName()); //Add JAR file to the list
					System.out.println(TAG + " new JAR file found: " + file.getName());		
				}
				
			}
			
			combo.getItems().addAll(names); //Add all JAR files to the combo list
			combo.getSelectionModel().selectFirst(); //Show first item by default
		}
		else{
			
			String error = "No JAR files found. There is nothing to show.";
			System.out.println(TAG + ": " + error);	
			showError(error);
		}
		
		pane.setCenter(combo);
	}
	
	//Get project folder
	private void getRootFolder(){
			
		System.out.println(TAG + ": setAbsPath method called");		
		rootFolderPath = new File("").getAbsolutePath(); //Get absolute project path	
		System.out.println(TAG + " rootFolderPath: " + rootFolderPath);		
	}
	
	//Scan project directory ("executable" folder) 
	private void scanDirectory(){
		
		System.out.println(TAG + ": scanDirectory method called");		
		
		getRootFolder();
		String fullPath = rootFolderPath + exeFolder; //Set full path for "executable" folder
		System.out.println(TAG + " fullPath: "  + fullPath);		
		rootFolder = new File(fullPath); //Set "executable" folder		
		fileArray = rootFolder.listFiles(); //Get all files from "executable" folder
		System.out.println(TAG + ": " + fileArray.length + " files found");		
	}
	
	//Show error dialog
	private void showError(String error){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(ERROR);
		alert.setHeaderText(ERRORHEAD);
		alert.setContentText(error);
		alert.showAndWait();
	}
	
	//Show exception dialog
	private void showException(String exceptionName, String exceptionText){
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(ERROR);
		alert.setHeaderText(EXCEPTION);
		alert.setContentText(exceptionName);
		
		Label label = new Label("The exception stacktrace was:");
		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);
				
		alert.showAndWait();
	}
	
	
	//END
}
