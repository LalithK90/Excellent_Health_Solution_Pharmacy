package com.excellenthealthSolution.pharmacy.resourse.companyResource.entity;

import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Gender;
import com.excellenthealthSolution.pharmacy.general.consultation.entity.Enum.Title;
import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Enum.CivilStatus;
import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Enum.Designation;
import com.excellenthealthSolution.pharmacy.resourse.companyResource.entity.Enum.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @NotNull(message = "Number is required")
    private String number;

    @Enumerated(EnumType.STRING)
    private Title title;

    @Size(min = 5, message = "Your name cannot be accept")
    private String name;

    @Size(min = 5, message = "At least 5 characters should be include calling name")
    private String callingName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Size(max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 ")
    private String nic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;

    //@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$",message = "Please provide valid email")
    @Email
    private String email;

    @Size(min = 9, message = "Can not accept this mobile number")
    private String mobile;

    private String land;

    @Size(min = 5, message = "Should be need to provide valid address !!")
    private String address;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate doassignment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;


    public Employee() {
    }

    public Employee(String number, Title title, String name, String callingName, Gender gender, String nic, LocalDate dateOfBirth, CivilStatus civilStatus, String email, String mobile, String land, String address, Designation designation, EmployeeStatus employeeStatus, LocalDate doassignment, LocalDate createdAt, LocalDate updatedAt) {
        this.number = number;
        this.title = title;
        this.name = name;
        this.callingName = callingName;
        this.gender = gender;
        this.nic = nic;
        this.dateOfBirth = dateOfBirth;
        this.civilStatus = civilStatus;
        this.email = email;
        this.mobile = mobile;
        this.land = land;
        this.address = address;
        this.designation = designation;
        this.employeeStatus = employeeStatus;
        this.doassignment = doassignment;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
