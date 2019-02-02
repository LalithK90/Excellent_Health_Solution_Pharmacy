package com.excellenthealthSolution.pharmacy.resourse.companyResource.entity;

import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Gender;
import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Title;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "This code is already add or enter incorrectly")
    private String number;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    @Size(message = "NIC should be contained character 10 or 12", min = 10, max = 12)
    private String nic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday should be included")
    private LocalDate dateOfBirth;

    @Email(message = "Please provide a valid Email")
    private String email;

    @Min(value = 9, message = "Should be needed to enter valid mobile number")
    private String mobile;

    private String land;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

    public Patient() {
     }

    public Patient(String number, Title title, String name, Gender gender, String nic, LocalDate dateOfBirth, String email, String mobile, String land, LocalDate createdAt, LocalDate updatedAt) {
        this.number = number;
        this.title = title;
        this.name = name;
        this.gender = gender;
        this.nic = nic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobile = mobile;
        this.land = land;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient patient = (Patient) obj;
        return Objects.equals(id, patient.id);
}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
