package TripManagmentSystem.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REGULAR")
public class RegularUser extends User {
    
    private Integer loyaltyPoints;
    
    public RegularUser() {
        this.loyaltyPoints = 0;
    }
    
    public RegularUser(String name, String email) {
        super(name, email);
        this.loyaltyPoints = 0;
    }
    
    @Override
    public String getUserType() {
        return "REGULAR_USER";
    }
    
    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }
    
    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
