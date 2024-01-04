package com.example.demo.model;

// Appointment.java
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private OffsetDateTime dateTime;
    @Column( name = "customer_name")
    private String customerName;
    @Column( name = "notes")
    private String notes;
    @Column( name = "numara")
    private String numara;

    @Column( name = "sms_sent")
    private Boolean smsSent;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public Boolean getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(Boolean smsSent) {
        this.smsSent = smsSent;
    }
}
