package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class MessagesScreen extends GUIScene{
	public static Node getView() {
		VBox root = new VBox();
		
		Button returnButton = new Button("Return");
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			navigateTo(PatientHomepage.getView());
		}
		});
		
		root.getChildren().add(returnButton);
		
		return root;
	}
}
