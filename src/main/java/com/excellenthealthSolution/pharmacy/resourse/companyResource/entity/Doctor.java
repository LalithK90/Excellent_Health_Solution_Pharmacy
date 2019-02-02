package com.excellenthealthSolution.pharmacy.resourse.companyResource.entity;

import com.excellenthealthSolution.pharmacy.general.consultation.entity.Consultations;
import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Gender;
import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Title;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@JsonIgnoreProperties(value = ("updateDate"),allowGetters = true)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Title title;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(fetch = FetchType.EAGER)
    private Consultations consultations;

    @Column(unique = true)
    private Integer slmcNumber;

    private String mobile;

    private String land;

    @Email(message = "Please provide valid email")
    private String email;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createAt;

    public Doctor() {
    }

    public Doctor(Title title, String name, Gender gender, Consultations consultations, Integer slmcNumber, String mobile, String land, String email, LocalDate createAt) {
        this.title = title;
        this.name = name;
        this.gender = gender;
        this.consultations = consultations;
        this.slmcNumber = slmcNumber;
        this.mobile = mobile;
        this.land = land;
        this.email = email;
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Doctor)) return false;
        Doctor doctor = (Doctor) obj;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
