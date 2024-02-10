package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(catalog = "clinic", schema = "public", name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "passport")
    private String passport;

    @Column(name = "address")
    private String address;
}
