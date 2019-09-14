package com.excellenthealthSolution.pharmacy.security.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( unique = true )
    private Integer id;

    private String roleName;

    @ManyToMany( mappedBy = "roles", fetch = FetchType.EAGER )
    private Set< User > users;

}
