package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;
import java.util.ArrayList;

public class MessagesScreenNurse extends GUIScene {

    public static Node getView() {
        VBox root = new VBox();

        Button returnButton = new Button("Return");
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                navigateTo(MedicalStaffHomepage.getView());
            }
        });

        ListView<String> messagesListView = new ListView<>();
        messagesListView.setPrefSize(400, 300);

        // Assuming you have a method to retrieve both sent and received messages for the nurse
        ArrayList<Message> nurseMessages = retrieveNurseMessages();

        // Displaying messages in the ListView
        for (Message message : nurseMessages) {
            String senderName = message.getSender().getFirstName() + " " + message.getSender().getLastName();
            String messageContent = message.getContent();
            String messageInfo = senderName + ": " + messageContent;
            messagesListView.getItems().add(messageInfo);
        }

        // TextFields for recipient's information and message content
        TextField recipientFirstNameField = new TextField();
        recipientFirstNameField.setPromptText("Recipient's First Name");

        TextField recipientLastNameField = new TextField();
        recipientLastNameField.setPromptText("Recipient's Last Name");

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here");

        // Button to send the message
        Button sendButton = new Button("Send");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String recipientFirstName = recipientFirstNameField.getText();
                String recipientLastName = recipientLastNameField.getText();
                String content = messageField.getText();

                if (!recipientFirstName.isEmpty() && !recipientLastName.isEmpty() && !content.isEmpty()) {
                    User recipient = UserList.findUser(recipientFirstName, recipientLastName); // Using UserList to find user
                    if (recipient != null && (recipient.getUserType() == UserType.DOCTOR || recipient.getUserType() == UserType.NURSE)) {
                        currentUser.sendMessage(recipient, content);
                        // Update GUI to display sent message
                        String sentMessageInfo = "You: " + content;
                        messagesListView.getItems().add(sentMessageInfo);
                        messageField.clear();
                    } else {
                        // Display an error message or handle the case where recipient is not found or is not a doctor or nurse
                    }
                }
            }
        });

        root.getChildren().addAll(returnButton, messagesListView, recipientFirstNameField, recipientLastNameField, messageField, sendButton);

        return root;
    }

    // Method to retrieve both sent and received messages for the nurse
    private static ArrayList<Message> retrieveNurseMessages() {
        ArrayList<Message> nurseMessages = new ArrayList<>();

        // Assuming you have a method to retrieve both sent and received messages based on the current user
        // Replace this with your logic to retrieve messages

        return nurseMessages;
    }
}
