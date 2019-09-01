package com.excellenthealthSolution.pharmacy.asset.medicine.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},allowGetters = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GenericName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "generic_name")
    private List<Medicine> medicines;
}
