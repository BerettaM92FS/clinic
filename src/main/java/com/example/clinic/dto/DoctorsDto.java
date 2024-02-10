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
public class DoctorsDto {
    private UUID id;
    private String fio;
    private SpecialityDto spec;
    private Date hiringDate;
    private String phone;
    private String address;
}
