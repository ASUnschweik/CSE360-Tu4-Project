package ProjectThree;

import java.time.LocalDate;
import java.util.ArrayList;

public class Visit {
    private int bodyTemperature;
    private int[] bloodPressure;
    private LocalDate date;
    private String prescriptions;
    private String diagnosis;
    private String instructions;
    private String generalNotes;

    // Default constructor
    public Visit() {
    	date = LocalDate.now();
    }

    // Specific constructor
    public Visit(int bodyTemperature, int[] bloodPressure, String prescriptions, String instructions, String generalNotes) {
    	this.date = LocalDate.now();
    	this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
        this.prescriptions = prescriptions;
        this.instructions = instructions;
        this.generalNotes = generalNotes;
    }

    // Getters and setters
    public int getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(int bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int[] getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int[] bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    public LocalDate getDate() {
    	return date;
    }
    
    public void setDate(LocalDate date) {
    	this.date = date;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
    

    public String getDiagnosis() {
    	return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
    	this.diagnosis = diagnosis;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getGeneralNotes() {
        return generalNotes;
    }

    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }
    
    public String toString() {
    	String temp = "Visit" +
                "\nBody Temperature:" + bodyTemperature +
                "\nBlood Pressure:" + bloodPressure[0] +
                "/" + bloodPressure[1] +
                "\nPrescriptions: " + prescriptions +
                "Instructions: " + instructions;
        if(!generalNotes.equals(null)) temp += "General Notes: " + generalNotes; 
        return temp;
    }
}

