package ProjectThree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application {
	public static Stage primaryStage;
	
	public void start(Stage currentView) {
		main.primaryStage = currentView;
		primaryStage.setTitle("Tu4 Medical Office");
		GUIScene.navigateTo(LoginPage.getView());
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
