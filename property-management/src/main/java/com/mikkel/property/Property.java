package com.mikkel.property;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "properties")
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Address is required")
    @Column(nullable = false)
    private String address;

    private String propertyType;

    @Size(min = 1, message = "Owner name cannot be empty if provided")
    private String owner;

    @Min(value = 0, message = "Property assessment must be greater than 0")
    private double propertyAssessment;

    public Property() {}

    public Property(String address, String propertyType, String owner, double propertyAssessment) {
        this.address = address;
        this.propertyType = propertyType;
        this.owner = owner;
        this.propertyAssessment = propertyAssessment;
    }

    public long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPropertyType() { return propertyType; }
    public void setPropertyType(String propertyType) { this.propertyType = propertyType; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public double getPropertyAssessment() { return propertyAssessment; }
    public void setPropertyAssessment(double propertyAssessment) { this.propertyAssessment = propertyAssessment; }

}
