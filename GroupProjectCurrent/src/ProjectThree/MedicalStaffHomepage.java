package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class MedicalStaffHomepage extends GUIScene {
	public static Node getView() {
		BorderPane root = new BorderPane();
		
		Label welcome = new Label();
		if(currentUser.getUserType()==UserType.DOCTOR) {
			welcome.setText("Welcome Dr. " + currentUser.getLastName());
		}
		else {
			welcome.setText("Welcome Nurse " + currentUser.getLastName());
		}
		
		Label birthday = new Label("Birthdate: " + currentUser.getDateOfBirth().toString());
		Label contact = new Label("Contact email:\n"+currentUser.getEmail());
		
		VBox top = new VBox();
		top.getChildren().addAll(welcome,birthday,contact);
		root.setTop(top);
		
		
		Button patientLookup = new Button("Patient Lookup");
		Button messages = new Button("Messages");
		
		patientLookup.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				navigateTo(PatientLookupPage.getView());
			}
		});
		
		if(currentUser.getUserType()== UserType.DOCTOR) {
			messages.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					navigateTo(MessagesScreenDoctor.getView());
				}
			});
		}
		else if(currentUser.getUserType()== UserType.NURSE) {
			messages.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					navigateTo(MessagesScreenNurse.getView());
				}
			});
		}
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(patientLookup,messages);
		
		root.setCenter(bottom);
		
		return root;
	}
}
