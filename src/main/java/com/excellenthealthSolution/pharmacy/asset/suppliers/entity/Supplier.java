package com.excellenthealthSolution.pharmacy.asset.suppliers.entity;

import com.excellenthealthSolution.pharmacy.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode( callSuper = true )
public class Supplier extends AuditEntity {

    @Size(min = 4, message = "Provide valid name")
    private String name;

    @Size(min = 10, message = "Provide valid name")
    private String address;

    @Size(min = 10, message = "Provide valid phone number")
    private String number;

    @Email(message = "Provide valid email")
    private String email;

}
