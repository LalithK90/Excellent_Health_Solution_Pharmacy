package com.excellenthealthSolution.pharmacy.asset.medicine.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PharmacopoeiasShortCode {
    BP("British Pharmacopoeia"),
    USP("United States Pharmacopoeia"),
    BPC("British Pharmaceutical Codex"),
    SLP("Sri Lanka Pharmacopoeia"),
    IP("Indian Pharmacopoeia"),
    JP("Japanese Pharmacopoeia"),
    ChP("Chinese Pharmacopoeia"),
    CSL("Czechoslovak Pharmacopoeia"),
    PhBoh("Czech Pharmacopoeia"),
    PhEur("European Pharmacopoeia"),
    PhFr("French Pharmacopoeia"),
    DAB("German Pharmacopoeia"),
    PhHg("Hungarian Pharmacopoeia"),
    PhInt("InternationalPharmacopoeia"),
    YP("Yugoslav Pharmacopoeia");
    private final String pharmacopoeiasShortCode;
}
