package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginCSS extends Application{

	
	private GridPane layout;
	private Text sceneTitle, action;
	private TextField userField;
	private PasswordField pwdField;
	private Label userName, userPwd;
	private Button btnLogin;
	private HBox hbBtn;
	private CheckBox chkBox;
	private Scene scene;
	
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		
		setPaneLayout();
		setWinTitle();
		setUserNameField();
		setPwdField();
		setActionLbl();
		setLoginBtn();
		setChkBox();

		
		scene =  new Scene(layout, 300, 300);
		
		primaryStage.setTitle("LoginForm: CSS");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	private void setPaneLayout(){
		
		layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPadding(new Insets(25,25,25,25));
		
	}
	
	
	private void setWinTitle(){
		
		sceneTitle = new Text("Please Login: ");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		layout.add(sceneTitle, 0, 0, 2, 1);
	}
	
	
	private void setUserNameField(){
		
		userName = new Label("User Name:");
		userField = new TextField();
		layout.add(userName, 0, 1);
		layout.add(userField, 1, 1);
	}
	
	
	private void setPwdField(){
		
		userPwd = new Label("User Password:");
		pwdField = new PasswordField();
		layout.add(userPwd, 0, 2);
		layout.add(pwdField, 1, 2);
	}
	
	
	private void setActionLbl(){
		
		action = new Text("");
		layout.add(action, 1, 6);
	}
	
	
	private void setLoginBtn(){
		
		btnLogin = new Button("Login");
		hbBtn = new HBox(10);
		hbBtn.getChildren().add(btnLogin);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		btnLogin.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				action.setFill(Color.FIREBRICK);
				action.setText("'Login' button pressed");
			}
		});
		layout.add(hbBtn, 1, 3);
	}
	
	
	private void setChkBox(){
		
		chkBox = new CheckBox("Grid Lines Visible");
		chkBox.setSelected(false);
		chkBox.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				
				//Display GridLines
				action.setFill(Color.CORAL);
				action.setText("'Grid Lines Visible'\n check-box pressed");
				layout.setGridLinesVisible(chkBox.isSelected());		
			}
		});
		layout.add(chkBox, 1, 4);
	}
	
	
	//END
}
