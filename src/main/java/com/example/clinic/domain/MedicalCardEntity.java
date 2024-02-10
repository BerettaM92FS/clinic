package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(catalog = "clinic", schema = "public", name = "medical_card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalCardEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientsEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorsEntity doctor;

    @Column(name = "date_add")
    private Date dateAdd;

    @Column(name = "diagnosis")
    private String diagnosis;
}
