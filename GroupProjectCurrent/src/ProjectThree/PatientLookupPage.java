package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;


public class PatientLookupPage extends GUIScene {
	public static Node getView() {
		BorderPane root = new BorderPane();
		
		Label name = new Label("Patient's name");
		TextField nameField = new TextField();
		
		Label dob = new Label("Patient's DOB");
		DatePicker dobField = new DatePicker();
		Label errorMessage = new Label();
		
		VBox top = new VBox();
		top.getChildren().addAll(name,nameField,dob,dobField,errorMessage);
		root.setTop(top);
		
		
		
		Button patientRecords = new Button("Patient Records");
		patientRecords.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String[] s = new String[2];
				if(nameField.getText()!=null && nameField.getText().matches("^[A-Z]{1}[a-z]{1,}+ [A-Z]{1}[a-z]{1,}$")) {
					s = nameField.getText().split(" ",2);
					System.out.print("\n\n\nFirst Name: " + s[0] +"\n\n\nLast name; " +s[1]);
					User u = UserList.findUser(s[0], s[1]);
					if(u.getUserType() == UserType.PATIENT && dobField.getValue() == u.getDateOfBirth()) {
						navigateTo(PersonalRecordsScreen.getView(u));
					}
						
				}
				else {
					errorMessage.setText("Unable to find user");
				}
			}
		});
		
		
		Button beginExam = new Button("Begin examination");
		beginExam.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String[] s = new String[2];
				if(name.getText()!=null && name.getText().matches("^[A-Z]{1}[a-z]{1,}+ [A-Z]{1}[a-z]{1,}$")) {
					s = name.getText().split(" ",2);
					User u = UserList.findUser(s[0], s[1]);
					if(u.getUserType() == UserType.PATIENT && dobField.getValue() == u.getDateOfBirth()) {
						if(currentUser.getUserType() == UserType.DOCTOR) GUIScene.navigateTo(DoctorExamScreen.getView(u));
						else navigateTo(NurseExamScreen.getView(u));
					}
						
				}
				else {
					errorMessage.setText("Unable to find user");
				}
			}
		});
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(patientRecords,beginExam);
		root.setCenter(bottom);
		
		
		
		
		
		return root;
	}
}
