package ProjectThree;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class LoginPage extends GUIScene{
	public static Node getView() {
		VBox root = new VBox();
		
		Label email = new Label("Email address");
		TextField emailField = new TextField();
		Label password = new Label("Password");
		PasswordField passwordField = new PasswordField();
		Label newHere = new Label("New here?");
		Label errorMessage = new Label();
		
		
		Button login = new Button("Login");
		
		Hyperlink forgotPassword = new Hyperlink("Forgot password?");
		Hyperlink signUp = new Hyperlink("Sign up");
		
		Hyperlink staffRegister = new Hyperlink("New staff members click here");
		
		HBox register = new HBox();
		register.getChildren().addAll(newHere,signUp);
		
		
		
		login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")
                        && passwordField.getText().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
                    String s1 = emailField.getText();
                    String s2 = passwordField.getText();
                    User u = UserList.loginUser(s1, s2);
                    if(u != null) {
                        currentUser = u;
                        switch(u.getUserType()) {
                            case PATIENT:
                                navigateTo(PatientHomepage.getView());
                            	break;
                            case DOCTOR:
                                navigateTo(MedicalStaffHomepage.getView());
                                break;
                            case NURSE:
                                navigateTo(MedicalStaffHomepage.getView());
                                break;
                        }
                        return;
                    }
                    
                }
                else {
                	errorMessage.setText("Incorrect email or password");
                	return;
                }
			}
		});
		
		
		signUp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				navigateTo(RegistrationPage.getView());
			}
		});
		
		staffRegister.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				navigateTo(StaffRegistrationPage.getView());
			}
		});
		
		
		
		root.getChildren().addAll(errorMessage,email,emailField,password,passwordField,login,register,forgotPassword,staffRegister);
	
		return root;
	}
}
