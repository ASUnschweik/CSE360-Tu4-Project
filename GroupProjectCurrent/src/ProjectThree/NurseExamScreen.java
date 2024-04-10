package ProjectThree;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

import java.time.LocalDate;

import ProjectThree.User.UserType;
import javafx.event.*;

public class NurseExamScreen extends GUIScene {
	public static Node getView(User u) {
		HBox root = new HBox();
		VBox left = new VBox();
		VBox center = new VBox();
		VBox right = new VBox();
		
		Patient p = (Patient) u;
		
		Label errorMessage = new Label();
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				navigateTo(MedicalStaffHomepage.getView());
			}
		});
		
		left.getChildren().addAll(errorMessage,back);
		
		
		Label vitals = new Label("Vitals");
		Label height = new Label("Height");
		TextField heightField = new TextField();
		Label weight = new Label("Weight");
		TextField weightField = new TextField();
		Label bodyTemp = new Label("Body Temperature");
		TextField bodyTempField = new TextField();
		Label bloodPressure = new Label("Blood pressure");
		TextField bloodPressureField = new TextField();
		Button submit = new Button("Submit");
		submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(!heightField.getText().equals("") &&
						!weightField.getText().equals("") &&
						!bodyTempField.getText().equals("") &&
						!bloodPressureField.getText().equals("")) {
					
					Visit v = new Visit();
					
					String s = heightField.getText();
					if(s.matches("^[0-9]{2}") && s.length()<3) {
						p.setHeight(Integer.parseInt(s));
					}
					else {
						errorMessage.setText("Invalid height");
						return;
					}
					
					s = weightField.getText();
					if(s.matches("^[0-9]{2,3}")&& s.length()<4) {
						p.setWeight(Integer.parseInt(s));
					}
					else {
						errorMessage.setText("invalid weight");
						return;
					}
					
					s = bodyTempField.getText();
					if(s.matches("^[0-9]{2,3}")&& s.length()<4) {
						v.setBodyTemperature(Integer.parseInt(s));
					}
					else {
						errorMessage.setText("Invalid body temperature");
						return;
					}
					
					s = bloodPressureField.getText();
					if(s.matches("[0-9]{3}\\/{1}[0-9]{2,3}") && s.length()<10) {
						String[] s1 = new String[2];
						s1 = s.split("/",2);
						int[] i = new int[2];
						i[0] = Integer.parseInt(s1[0]);
						i[1] = Integer.parseInt(s1[1]);
						v.setBloodPressure(i);
					}
					else {
						errorMessage.setText("Invalid blood pressure");
						return;
					}
					
					p.getPreviousVisitInformation().add(0,v);
					navigateTo(MedicalStaffHomepage.getView());
				}
				else {
					errorMessage.setText("Please fill out all sections");
				}
				
			}
		});
		
		center.getChildren().addAll(vitals,height,heightField,weight,weightField,bodyTemp,bodyTempField,bloodPressure,bloodPressureField,submit);
		
		
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
		
		right.getChildren().addAll(history,historyTable);
		
		
		root.getChildren().addAll(left,center,right);
		return root;
	}
}
