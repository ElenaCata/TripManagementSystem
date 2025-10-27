package TripManagmentSystem.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseEntity {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt)
    {this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}