package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import ProjectThree.User.UserType;
import javafx.event.*;

public class DoctorExamScreen extends GUIScene{
	public static Node getView(User u) {
		HBox root = new HBox();
		VBox left = new VBox();
		VBox center = new VBox();
		VBox right = new VBox();
		
		Patient p = (Patient) u;
		
		Label generalNotes = new Label("General Notes");
		TextField notesField = new TextField();
		
		left.getChildren().addAll(generalNotes, notesField);
		
		Label thisDiagnosis = new Label("Diagnosis");
		TextField diagnosisField = new TextField();
		Label prescriptions = new Label("Prescriptions");
		TextField prescriptionsField = new TextField();
		Label instructions = new Label("Instructions");
		TextField instructionsField = new TextField();
		Label errorMessage = new Label();
		Button finishExam = new Button("Finish exam");
		finishExam.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(!diagnosisField.getText().equals("") &&
						!prescriptionsField.getText().equals("")) {
					p.getPreviousVisitInformation().get(0).setDiagnosis(diagnosisField.getText());
					p.getPreviousVisitInformation().get(0).setPrescriptions(prescriptionsField.getText());
					p.getPreviousVisitInformation().get(0).setInstructions(instructionsField.getText());
					navigateTo(MedicalStaffHomepage.getView());
				}
				else {
					errorMessage.setText("Please enter information for patient");
				}
			}
		});
		
		center.getChildren().addAll(thisDiagnosis,diagnosisField,prescriptions,prescriptionsField,instructions,instructionsField,errorMessage,finishExam);
		
		Label history = new Label("History");
		GridPane historyTable = new GridPane();
		Label diagnosis = new Label("Diagnosis");
		Label date = new Label("Date");
		Label treatment = new Label("Treatement");
		
		historyTable.add(diagnosis, 0, 0);
		historyTable.add(date, 1, 0);
		historyTable.add(treatment, 2, 0);
		
		int size = 0;
		for(Visit v1 : p.getPreviousVisitInformation()) {
			if(size>3) break;
			if(v1.getDiagnosis() != null && v1.getPrescriptions()!=null) {
				historyTable.add(new Label(v1.getDiagnosis()),0,size+1);
				historyTable.add(new Label(v1.getDate().toString()), 1, size+1);
				historyTable.add(new Label(v1.getPrescriptions()), 2, size+1);
				size++;
			}
		}
		
		Label vitals = new Label("Vitals");
		String s = "";
		s+= p.getHeight();
		Label height = new Label("Height: " + s);
		s="";
		s+= p.getWeight();
		Label weight = new Label("Weight: " + s);
		s="";
		s+=p.getPreviousVisitInformation().get(0).getBodyTemperature();
		Label bodyTemp = new Label("Body temperature: " + s);
		s = p.getPreviousVisitInformation().get(0).getBloodPressure()[0]+"/"+p.getPreviousVisitInformation().get(0).getBloodPressure()[1];
		Label bloodPresure = new Label("Blood pressure: " + s);
		
		right.getChildren().addAll(history,historyTable, vitals, height, weight, bodyTemp, bloodPresure);
		
		root.getChildren().addAll(left,center,right);
		return root;
	}
}
