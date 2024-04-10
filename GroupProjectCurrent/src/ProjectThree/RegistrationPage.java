package ProjectThree;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class RegistrationPage extends GUIScene{
	public static Node getView() {
		VBox root = new VBox();
		HBox top = new HBox();
		VBox bottom = new VBox();
		VBox topLeft = new VBox();
		VBox topRight = new VBox();
		
		 // Create labels and text fields
        Label email = new Label("Email:");
        TextField emailField = new TextField();

        Label password = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label confirmPassword = new Label("Confirm Password:");
        PasswordField confirmPasswordField = new PasswordField();

        Label firstName = new Label("First Name:");
        TextField firstNameField = new TextField();

        Label lastName = new Label("Last Name:");
        TextField lastNameField = new TextField();

        Label dob = new Label("Date of Birth:");
        DatePicker dobField = new DatePicker();

        Label insuranceProvider = new Label("Insurance Provider:");
        TextField insuranceProviderField = new TextField();

        Label pharmacy = new Label("Preferred Pharmacy:");
        TextField pharmacyField = new TextField();

        Label errorMessage = new Label("");
        
        Button register = new Button("Register");
        register.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		if(GUIScene.hasText(emailField) && 
       			GUIScene.hasText(passwordField) && GUIScene.hasText(confirmPasswordField) &&
   				GUIScene.hasText(firstNameField) && GUIScene.hasText(lastNameField) &&
       			dobField.getValue()!=null && GUIScene.hasText(insuranceProviderField) &&
       			GUIScene.hasText(pharmacyField)) {
        			
        			String s;
        			Patient p = new Patient();
        			
        			s = emailField.getText();
					if(s.matches("^[a-zA-Z.]{1,}+[@]{1}+[a-zA-Z]{1,}+[.]{1}+[a-zA-Z]{2,4}$")) {
						if(UserList.emailTaken(s)) {
							errorMessage.setText("Email is already taken");
							return;
						}
						p.setEmail(s);
					}
					else {
						errorMessage.setText("Invalid email");
						return;
					}
					
					s = passwordField.getText();
					if(s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
						if(s.equals(confirmPasswordField.getText())) {
							p.setPassword(s);
						}
						else {
							errorMessage.setText("Passwords do not match");
							return;
						}
					}
					else {
						errorMessage.setText("Password must contain a minimum of eight characters, at least one uppercase letter, one lowercase letter, one number, and one special character:");
						return;
					}
					
					
					s = firstNameField.getText();
					if(s.matches("^[A-Z]{1}[a-z]{0,15}$")) {
						p.setFirstName(s);
					}
					else {
						errorMessage.setText("Invalid first name");
						return;
					}
					

					s = lastNameField.getText();
					if(s.matches("^[A-Z]{1}[a-z]{0,15}$")) {
						p.setLastName(s);
					}
					else {
						errorMessage.setText("Invalid last name");
						return;
					}
					
					p.setDateOfBirth(dobField.getValue());
					
					s = insuranceProviderField.getText();
					if(s.matches("^[a-zA-Z]{3,15}$")) {
						p.setInsuranceProvider(s);
					}
					else {
						errorMessage.setText("Invalid insurance provider");
						return;
					}
					
					
					s = pharmacyField.getText();
					if(s.matches("^[a-zA-Z]{3,15}$")) {
						p.setPreferredPharmacy(s);
					}
					else {
						errorMessage.setText("Invalid pharmacy");
						return;
					}
					
					p.setUserType(UserType.PATIENT);
					UserList.users.add(p);
					currentUser = p;
        			
					navigateTo(PatientHomepage.getView());
        		}
        		else {
        			errorMessage.setText("Please fill out all fields");
        		}
        	}
        });
        
        topLeft.getChildren().addAll(email,emailField,password,passwordField,confirmPassword,confirmPasswordField);
        //add orientation stuff here
        topRight.getChildren().addAll(firstName,firstNameField,lastName,lastNameField,dob,dobField);
      //add orientation stuff here
        bottom.getChildren().addAll(insuranceProvider,insuranceProviderField,pharmacy,pharmacyField,register,errorMessage);
      //add orientation stuff here
        top.getChildren().addAll(topLeft,topRight);
      //add orientation stuff here
        root.getChildren().addAll(top,bottom);
      //add orientation stuff here
		
		return root;
	}
}
