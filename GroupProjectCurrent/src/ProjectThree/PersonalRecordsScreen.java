package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class PersonalRecordsScreen extends GUIScene{
	public static Node getView() {
		Patient patientUser = (Patient) currentUser;
		HBox root = new HBox();
		VBox left = new VBox();
		VBox center = new VBox();
		VBox right = new VBox();
		
		Label name = new Label("Name");
		TextField userName = new TextField();
		userName.setText(patientUser.getFirstName()+" "+patientUser.getLastName());
		userName.setEditable(false);
		
		Label dob = new Label("Birthday");
		DatePicker dobField = new DatePicker();
		dobField.setValue(patientUser.getDateOfBirth());
		dobField.setEditable(false);
		
		Label contactInfo = new Label("Contact phone number");
		TextField contactInfoField = new TextField();
		contactInfoField.setText(patientUser.getContactInformation());
		contactInfoField.setEditable(false);
		
		Label address = new Label("Address");
		TextField addressField = new TextField();
		addressField.setText(patientUser.getAddress());
		addressField.setEditable(false);
		
		Label hw = new Label("Height, Weight");
		TextField hwField = new TextField();
		hwField.setText(patientUser.getHeight() + ", " + patientUser.getWeight());
		hwField.setEditable(false);
		
		Label errorMessage = new Label();
		
		Button edit = new Button("Edit");
		edit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(edit.getText().equals("Edit")) {
					userName.setEditable(true);
					dobField.setEditable(true);
					contactInfoField.setEditable(true);
					addressField.setEditable(true);
					hwField.setEditable(true);
					edit.setText("Save");
				}
				else {
					String[] s = new String[2];
					if(userName.getText()!=null && userName.getText().matches("^[A-Z]{1}[a-z]{1,}+ [A-Z]{1}[a-z]{1,}$")) {
						s = userName.getText().split(" ",2);
						patientUser.setFirstName(s[0]);
						patientUser.setLastName(s[1]);
					}
					else {
						errorMessage.setText("Invallid name");
						return;
					}
					
					if(dobField.getValue() != null) {
						patientUser.setDateOfBirth(dobField.getValue());
					}
					else {
						errorMessage.setText("Invallid date of birth");
						return;
					}
					
					s[0] = contactInfoField.getText();
					if(s[0]!=null && s[0].matches("^\\s*[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
						patientUser.setContactInformation(s[0]);
					}
					else {
						errorMessage.setText("Invalid phone number");
						return;
					}
					
					if(addressField.getText()!=null && addressField.getText().length()<500){
						patientUser.setAddress(addressField.getText());
					}
					else {
						errorMessage.setText("Please enter an address");
						return;
					}
					
					if(hwField.getText()!=null && hwField.getText().matches("^[0-9]{2}+, [0-9]{2,3}$")) {
						s = hwField.getText().split(", ",2);
						patientUser.setHeight(Integer.parseInt(s[0]));
						patientUser.setWeight(Integer.parseInt(s[1]));
					}
					else {
						errorMessage.setText("Height must be in inches and weight must be in pounds");
						return;
					}
					
					userName.setEditable(false);
					dobField.setEditable(false);
					contactInfoField.setEditable(false);
					addressField.setEditable(false);
					hwField.setEditable(false);
					edit.setText("Edit");
				}
			}
		});
		
		left.getChildren().addAll(name,userName,dob,dobField,contactInfo,contactInfoField,address,addressField,hw,hwField,errorMessage, edit);
		
		
		
		Label centerLabel = new Label("Allergies and health history");
		center.getChildren().add(centerLabel);
		
		Label temp = new Label();
		for(String s : patientUser.getAllergies()) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		for(String s : patientUser.getMedicalHistory() ) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		Button returnButton = new Button("Return");
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			navigateTo(PatientHomepage.getView());
		}
		});
		center.getChildren().add(returnButton);
		
		Label rightLabel = new Label("Immunization records");
		right.getChildren().add(rightLabel);
		
		for(String s : patientUser.getImmunizationRecords()) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		
		root.getChildren().addAll(left,center,right);
		return root;
	}



	public static Node getView(User u) {
		Patient patientUser = (Patient) u;
		HBox root = new HBox();
		VBox left = new VBox();
		VBox center = new VBox();
		VBox right = new VBox();
		
		Label name = new Label("Name");
		TextField userName = new TextField();
		userName.setText(patientUser.getFirstName()+" "+patientUser.getLastName());
		userName.setEditable(false);
		
		Label dob = new Label("Birthday");
		DatePicker dobField = new DatePicker();
		dobField.setValue(patientUser.getDateOfBirth());
		dobField.setEditable(false);
		
		Label contactInfo = new Label("Contact phone number");
		TextField contactInfoField = new TextField();
		contactInfoField.setText(patientUser.getContactInformation());
		contactInfoField.setEditable(false);
		
		Label address = new Label("Address");
		TextField addressField = new TextField();
		addressField.setText(patientUser.getAddress());
		addressField.setEditable(false);
		
		Label hw = new Label("Height, Weight");
		TextField hwField = new TextField();
		hwField.setText(patientUser.getHeight() + ", " + patientUser.getWeight());
		hwField.setEditable(false);
		
		Label errorMessage = new Label();
		
		Button edit = new Button("Edit");
		edit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(edit.getText().equals("Edit")) {
					userName.setEditable(true);
					dobField.setEditable(true);
					contactInfoField.setEditable(true);
					addressField.setEditable(true);
					hwField.setEditable(true);
					edit.setText("Save");
				}
				else {
					String[] s = new String[2];
					if(userName.getText()!=null && userName.getText().matches("^[A-Z]{1}[a-z]{1,}+ [A-Z]{1}[a-z]{1,}$")) {
						s = userName.getText().split(" ",2);
						patientUser.setFirstName(s[0]);
						patientUser.setLastName(s[1]);
					}
					else {
						errorMessage.setText("Invallid name");
						return;
					}
					
					if(dobField.getValue() != null) {
						patientUser.setDateOfBirth(dobField.getValue());
					}
					else {
						errorMessage.setText("Invallid date of birth");
						return;
					}
					
					s[0] = contactInfoField.getText();
					if(s[0]!=null && s[0].matches("^\\s*[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
						patientUser.setContactInformation(s[0]);
					}
					else {
						errorMessage.setText("Invalid phone number");
						return;
					}
					
					if(addressField.getText()!=null && addressField.getText().length()<500){
						patientUser.setAddress(addressField.getText());
					}
					else {
						errorMessage.setText("Please enter an address");
						return;
					}
					
					if(hwField.getText()!=null && hwField.getText().matches("^[0-9]{2}+, [0-9]{2,3}$")) {
						s = hwField.getText().split(", ",2);
						patientUser.setHeight(Integer.parseInt(s[0]));
						patientUser.setWeight(Integer.parseInt(s[1]));
					}
					else {
						errorMessage.setText("Height must be in inches and weight must be in pounds");
						return;
					}
					
					userName.setEditable(false);
					dobField.setEditable(false);
					contactInfoField.setEditable(false);
					addressField.setEditable(false);
					hwField.setEditable(false);
					edit.setText("Edit");
				}
			}
		});
		
		left.getChildren().addAll(name,userName,dob,dobField,contactInfo,contactInfoField,address,addressField,hw,hwField,errorMessage, edit);
		
		
		
		Label centerLabel = new Label("Allergies and health history");
		center.getChildren().add(centerLabel);
		
		Label temp = new Label();
		for(String s : patientUser.getAllergies()) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		for(String s : patientUser.getMedicalHistory() ) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		Button returnButton = new Button("Return");
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e) {
			GUIScene.navigateTo(PatientLookupPage.getView()); //MedicalStaffHomepage
		}
		});
		center.getChildren().add(returnButton);
		
		Label rightLabel = new Label("Immunization records");
		right.getChildren().add(rightLabel);
		
		for(String s : patientUser.getImmunizationRecords()) {
			temp = new Label(s);
			temp.setStyle("-fx-text-fill: blue;");
			center.getChildren().add(temp);
		}
		
		root.getChildren().addAll(left,center,right);
		return root;
	}
	



}


