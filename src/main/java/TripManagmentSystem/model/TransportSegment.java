package TripManagmentSystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDate;

@Embeddable
public class TransportSegment {

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String fromLocation;
    private String toLocation;
    
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
    
    private double distanceKm;

    public TransportSegment() {}

    public TransportSegment(String description, LocalDate startDate, LocalDate endDate,
                            String fromLocation, String toLocation,
                            TransportType transportType, double distanceKm) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transportType = transportType;
        this.distanceKm = distanceKm;
    }

    // Getteri și setteri
    public String getDescription() { 
        return description; 
    }
    
    public void setDescription(String description) { 
        this.description = description; 
    }

    public LocalDate getStartDate() { 
        return startDate; 
    }
    
    public void setStartDate(LocalDate startDate) { 
        this.startDate = startDate; 
    }

    public LocalDate getEndDate() { 
        return endDate; 
    }
    
    public void setEndDate(LocalDate endDate) { 
        this.endDate = endDate; 
    }

    public String getFromLocation() { 
        return fromLocation; 
    }
    
    public void setFromLocation(String fromLocation) { 
        this.fromLocation = fromLocation; 
    }

    public String getToLocation() { 
        return toLocation; 
    }
    
    public void setToLocation(String toLocation) { 
        this.toLocation = toLocation; 
    }

    public TransportType getTransportType() { 
        return transportType; 
    }
    
    public void setTransportType(TransportType transportType) { 
        this.transportType = transportType; 
    }

    public double getDistanceKm() { 
        return distanceKm; 
    }
    
    public void setDistanceKm(double distanceKm) { 
        this.distanceKm = distanceKm; 
    }
}