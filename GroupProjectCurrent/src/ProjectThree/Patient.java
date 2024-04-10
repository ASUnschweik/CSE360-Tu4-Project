package ProjectThree;
import java.util.ArrayList;
import java.time.LocalDate;

public class Patient extends User {
    private String insuranceProvider;
    private String preferredPharmacy;
    private String contactInformation;
    private String address;
    private int height;
    private int weight;
    private ArrayList <Visit> previousVisitInformation;
    private ArrayList<String> medicalHistory;
    private ArrayList<String> allergies;
    private ArrayList<String> immunizationRecords;

    // Default constructor
    public Patient() {
    	previousVisitInformation = new ArrayList<>();
        medicalHistory = new ArrayList<>();
        allergies = new ArrayList<>();
        immunizationRecords = new ArrayList<>();
    }

    // Specific constructor
    public Patient(String email, String firstName, String lastName, String password, LocalDate dateOfBirth, UserType userType,
                   String insuranceProvider, String preferredPharmacy, String contactInformation, String address,
                   int height, int weight, ArrayList<Visit> previousVisitInformation, ArrayList<String> medicalHistory,
                   ArrayList<String> allergies, ArrayList<String> immunizationRecords) {
        super(email, firstName, lastName, password, dateOfBirth, userType);
        this.insuranceProvider = insuranceProvider;
        this.preferredPharmacy = preferredPharmacy;
        this.contactInformation = contactInformation;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.previousVisitInformation = previousVisitInformation;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.immunizationRecords = immunizationRecords;
    }

    // Getters and setters
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getPreferredPharmacy() {
        return preferredPharmacy;
    }

    public void setPreferredPharmacy(String preferredPharmacy) {
        this.preferredPharmacy = preferredPharmacy;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public ArrayList<Visit> getPreviousVisitInformation() {
        return previousVisitInformation;
    }

    public void setPreviousVisitInformation(ArrayList<Visit> previousVisitInformation) {
        this.previousVisitInformation = previousVisitInformation;
    }

    public ArrayList<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(ArrayList<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public ArrayList<String> getImmunizationRecords() {
        return immunizationRecords;
    }

    public void setImmunizationRecords(ArrayList<String> immunizationRecords) {
        this.immunizationRecords = immunizationRecords;
    }
    
    public String toString() {
        return super.toString() +
                "\nInsurance Provider: " + insuranceProvider + 
                "\n Preferred Pharmacy: " + preferredPharmacy + 
                "\nContact Information: " + contactInformation + 
                "\nAddress: " + address + 
                "\nHeight: " + height +
                "\nWeight: " + weight +
                "\nPrevious Visit Information: " + previousVisitInformation +
                "\nMedical History: " + medicalHistory +
                "\nAllergies: " + allergies +
                "Immunization Records: " + immunizationRecords +
                "} " + super.toString();
    }
}
