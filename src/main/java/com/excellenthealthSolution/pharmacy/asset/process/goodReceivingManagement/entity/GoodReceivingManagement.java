package com.excellenthealthSolution.pharmacy.asset.process.goodReceivingManagement.entity;

import com.excellenthealthSolution.pharmacy.security.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties( value = {"createdAt", "updatedAt"}, allowGetters = true )
public class GoodReceivingManagement {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( unique = true )
    private Integer id;

    private String quantity;

    private String itemPrice;
    //todo-> need more thing

    @Column( nullable = false, updatable = false )
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDate createdAt;
//todo -> supplier medicine

    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDate updatedAt;

    @ManyToOne
    private User createdUser;

    @ManyToOne
    private User updatedUser;
}



