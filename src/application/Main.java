package application;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{

	//Final parameters
	private final static String TAG = Main.class.getName().replaceAll("application.", "");	
	private final String btnName = "LAUNCH";
	private final String JAR = ".jar";
	private final String exeFolder = "\\src\\executable";

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
		scene = new Scene(pane, 300, 200);
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
					 
					String error = "The list is empty. There is nothing to show.";
					System.out.println(TAG + ": " + error);		
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
		mainStage.show();
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
	
	
	//END
}
