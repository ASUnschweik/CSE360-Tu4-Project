package ProjectThree;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.event.*;

public abstract class GUIScene {
	protected static User currentUser;
	
	public static boolean hasText(TextField t) {
		if(t.getText().isBlank()) return false;
		return true;
	}
	
	protected static void navigateTo(Node n) {
		BorderPane root = new BorderPane();
		Button logout = new Button("Logout");
		logout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				currentUser = null;
				navigateTo(LoginPage.getView());
			}
		});
		//root.setTop(Banner stuff);
		//add color and stuff here
		root.setTop(logout);
		root.setCenter(n);
		
		main.primaryStage.setScene(new Scene(root));
		main.primaryStage.show();
	}
	

}
