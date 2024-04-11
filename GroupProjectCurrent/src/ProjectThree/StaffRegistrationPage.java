package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class StaffRegistrationPage extends GUIScene{
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

        RadioButton doctor = new RadioButton("Doctor");
        RadioButton nurse = new RadioButton("Nurse");
        // Create a ToggleGroup to group the RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();
        doctor.setToggleGroup(toggleGroup);
        nurse.setToggleGroup(toggleGroup);
        // Set Doctor RadioButton as the default selection
        doctor.setSelected(true);

        
        Label errorMessage = new Label("");

        
        Button register = new Button("Register");
        register.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		if(GUIScene.hasText(emailField) && 
       			GUIScene.hasText(passwordField) && GUIScene.hasText(confirmPasswordField) &&
   				GUIScene.hasText(firstNameField) && GUIScene.hasText(lastNameField) &&
       			dobField.getValue()!=null) {
        			
        			String s;
        			User u = new User();
        			
        			s = emailField.getText();
					if(s.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
						if(UserList.emailTaken(s)) {
							errorMessage.setText("Email is already taken");
							return;
						}
						u.setEmail(s);
					}
					else {
						errorMessage.setText("Invalid email");
						return;
					}
					
					s = passwordField.getText();
					if(s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
						if(s.equals(confirmPasswordField.getText())) {
							u.setPassword(s);
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
						u.setFirstName(s);
					}
					else {
						errorMessage.setText("Invalid first name");
						return;
					}
					

					s = lastNameField.getText();
					if(s.matches("^[A-Z]{1}[a-z]{0,15}$")) {
						u.setLastName(s);
					}
					else {
						errorMessage.setText("Invalid last name");
						return;
					}
					
					u.setDateOfBirth(dobField.getValue());
					
					if(toggleGroup.getSelectedToggle() == doctor) u.setUserType(UserType.DOCTOR);
					else u.setUserType(UserType.NURSE);
					
					
					UserList.users.add(u);
					currentUser = u;
        			if(currentUser.getUserType()== UserType.DOCTOR) navigateTo(MedicalStaffHomepage.getView());
        			else if(currentUser.getUserType()== UserType.NURSE) navigateTo(MedicalStaffHomepage.getView());
        			else errorMessage.setText("Something went wrong");
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
        bottom.getChildren().addAll(doctor,nurse,register,errorMessage);
      //add orientation stuff here
        top.getChildren().addAll(topLeft,topRight);
      //add orientation stuff here
        root.getChildren().addAll(top,bottom);
      //add orientation stuff here
		
		
		return root;
	}
}
