package com.example.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalCardDto {
    private UUID id;
    private Integer number;
    private PatientsDto patient;
    private DoctorsDto doctor;
    private Date dateAdd;
    private String diagnosis;
}
