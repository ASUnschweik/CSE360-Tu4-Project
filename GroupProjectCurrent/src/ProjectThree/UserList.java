package ProjectThree;
import java.util.ArrayList;

public class UserList {
	public static ArrayList<User> users = new ArrayList<User>();
	
	public static User findUser(String firstName, String lastName) {
		for (User user : users) {
			if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				System.out.print("Found user" + user.toString());
				return user;
			}
		}
		return null;
	}

	public static boolean emailTaken(String email) {
		for (User user : users) {
			if(user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public static User loginUser(String email, String password) {
		for (User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}