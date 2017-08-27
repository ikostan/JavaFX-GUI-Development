package application;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{

	private final static String TAG = Main.class.getName();
	private final static String mNAME = "Method name: ";
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		printLog("start", "started");		

	
	}
	
	
	public static void main(String[] args) {

		System.out.println(TAG + "class called");
		printLog("main", "started");		
	}
	
	
	private static void printLog(String method, String action){
		
		System.out.println(TAG + " >>> " + mNAME + method + " >>> " + action);
	}

}
