package TripManagmentSystem.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BUSINESS")
public class BusinessUser extends User {
    
    private String companyName;
    private String taxId;
    
    public BusinessUser() {
    }
    
    public BusinessUser(String name, String email, String companyName, String taxId) {
        super(name, email);
        this.companyName = companyName;
        this.taxId = taxId;
    }
    
    @Override
    public String getUserType() {
        return "BUSINESS_USER";
    }
    
    public Double calculateDiscountedPrice(Double originalPrice) {
        return originalPrice * 0.9;
    }
    
    public boolean hasCorporateAccount() {
        return companyName != null && !companyName.isEmpty();
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getTaxId() {
        return taxId;
    }
    
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
