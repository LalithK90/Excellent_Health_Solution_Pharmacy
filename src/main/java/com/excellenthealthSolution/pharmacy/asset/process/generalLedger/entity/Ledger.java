package com.excellenthealthSolution.pharmacy.asset.process.generalLedger.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Ledger {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( unique = true )
    private Integer id;

    //todo => medicine

    //quantity price so many thing


}
