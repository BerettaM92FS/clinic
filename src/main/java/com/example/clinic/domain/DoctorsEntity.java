package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(catalog = "clinic", schema = "public", name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "fio")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "spec_id")
    private SpecialityEntity spec;

    @Column(name = "hiring_date")
    @Temporal(TemporalType.DATE)
    private Date hiringDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}
