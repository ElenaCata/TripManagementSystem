package TripManagmentSystem.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("AGENT")
public class TravelAgent extends User {
    
    private String agencyName;
    private String licenseNumber;
    
    public TravelAgent() {
    }
    
    public TravelAgent(String name, String email, String agencyName, String licenseNumber) {
        super(name, email);
        this.agencyName = agencyName;
        this.licenseNumber = licenseNumber;
    }
    
    @Override
    public String getUserType() {
        return "TRAVEL_AGENT";
    }
    
    public String getAgencyName() {
        return agencyName;
    }
    
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
