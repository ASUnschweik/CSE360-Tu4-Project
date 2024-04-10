package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class VisitSummaryScreen extends GUIScene{
	public static Node getView() {
		VBox root = new VBox();
		
		Label latestVisits = new Label("Latest Visits");
		
		root.getChildren().add(latestVisits);
		
		Patient p = (Patient) currentUser;
		if(p.getPreviousVisitInformation()!=null) {
			for(int i = 0; i<5 && i<p.getPreviousVisitInformation().size(); i++) {
				Label temp = new Label(p.getPreviousVisitInformation().get(i).toString());
				root.getChildren().add(temp);
			}
		}
		
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
