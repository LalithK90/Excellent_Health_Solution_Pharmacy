package com.excellenthealthSolution.pharmacy.general.consultation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "consultations")
@Getter
@Setter
public class Consultations {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;


    public Consultations() {
    }

    public Consultations(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Consultations)) return false;
        Consultations consultations = (Consultations) obj;
        return Objects.equals(id, consultations.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
