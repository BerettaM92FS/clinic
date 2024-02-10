package com.example.clinic.service;

import com.example.clinic.dto.MedicalCardDto;
import com.example.clinic.filter.MedicalCardFilter;

import java.util.List;
import java.util.UUID;

public interface MedicalCardService {

    MedicalCardDto getById(UUID id);

    List<MedicalCardDto> findAll();

    List<MedicalCardDto> findByFilter(MedicalCardFilter filter);

    String save(MedicalCardDto dto);

    String delete(UUID id);

    String update(MedicalCardDto dto);
}
