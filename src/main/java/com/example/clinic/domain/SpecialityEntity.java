package com.example.clinic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(catalog = "clinic", schema = "public", name = "speciality")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialityEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name")
    private String name;
}
