package com.excellenthealthSolution.pharmacy.asset.prescriber.entity;

import com.excellenthealthSolution.pharmacy.general.Enum.Gender;
import com.excellenthealthSolution.pharmacy.general.Enum.Title;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    private Integer SLMCNumber;

    private String mobile;

    private String land;

    @Email(message = "Please provide valid email")
    private String email;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createAt;

}
