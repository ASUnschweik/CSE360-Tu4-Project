package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;
import javafx.scene.image.*;

public class PatientHomepage extends GUIScene {
	public static Node getView() {
		BorderPane root = new BorderPane();
		HBox options = new HBox();
		/* I tried fucking around with putting an image in the button
		  but i couldnt figure it out soooo idk
		 
		Image img = new Image("./vistSummaryTemp.png");
	    ImageView view = new ImageView(img);
		
	    Button visitSummaryButton = new Button("",view);
	    */
		
		Button personalRecordsButton = new Button("Personal Records");
		Button visitSummaryButton = new Button("Visit Summary");
		Button messagingSystemButton = new Button("Messaging System");

		
		EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) {
				if(e.getSource()==personalRecordsButton) {
						navigateTo(PersonalRecordsScreen.getView());
				}
				else if(e.getSource() == visitSummaryButton) {
					navigateTo(VisitSummaryScreen.getView());
				}
				else {
					navigateTo(MessagesScreen.getView());
				}
			}
		};
		
		personalRecordsButton.setOnAction(buttonHandler);
		visitSummaryButton.setOnAction(buttonHandler);
		messagingSystemButton.setOnAction(buttonHandler);
		
		
	    options.getChildren().addAll(personalRecordsButton, visitSummaryButton,messagingSystemButton);
	    root.setCenter(options);
		return root;
	}
}
